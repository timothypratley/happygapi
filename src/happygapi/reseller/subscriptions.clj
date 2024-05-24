(ns happygapi.reseller.subscriptions
  "Google Workspace Reseller API: subscriptions.
  Perform common functions that are available on the Channel Services console at scale, like placing orders and viewing customer information
  See: https://developers.google.com/google-apps/reseller/docs/reference/rest/v1/subscriptions"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/google-apps/reseller/api/reference/rest/v1/subscriptions/get
  
  Required parameters: customerId, subscriptionId
  
  Optional parameters: none
  
  Gets a specific subscription. The `subscriptionId` can be found using the [Retrieve all reseller subscriptions](/admin-sdk/reseller/v1/how-tos/manage_subscriptions#get_all_subscriptions) method. For more information about retrieving a specific subscription, see the information descrived in [manage subscriptions](/admin-sdk/reseller/v1/how-tos/manage_subscriptions#get_subscription)."
  {:scopes ["https://www.googleapis.com/auth/apps.order"
            "https://www.googleapis.com/auth/apps.order.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:customerId :subscriptionId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://reseller.googleapis.com/"
     "apps/reseller/v1/customers/{customerId}/subscriptions/{subscriptionId}"
     #{:customerId :subscriptionId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/google-apps/reseller/api/reference/rest/v1/subscriptions/insert
  
  Required parameters: customerId
  
  Optional parameters: customerAuthToken, action, sourceSkuId
  
  Body: 
  
  {:skuName string,
   :creationTime string,
   :purchaseOrderId string,
   :billingMethod string,
   :trialSettings {:isInTrial boolean, :trialEndTime string},
   :suspensionReasons [string],
   :resourceUiUrl string,
   :customerId string,
   :transferInfo {:transferabilityExpirationTime string,
                  :minimumTransferableSeats integer,
                  :currentLegacySkuId string},
   :customerDomain string,
   :status string,
   :kind string,
   :skuId string,
   :seats {:numberOfSeats integer,
           :maximumNumberOfSeats integer,
           :licensedNumberOfSeats integer,
           :kind string},
   :plan {:planName string,
          :isCommitmentPlan boolean,
          :commitmentInterval {:startTime string, :endTime string}},
   :renewalSettings {:renewalType string, :kind string},
   :dealCode string,
   :subscriptionId string}
  
  Creates or transfer a subscription. Create a subscription for a customer's account that you ordered using the [Order a new customer account](/admin-sdk/reseller/v1/reference/customers/insert.html) method. For more information about creating a subscription for different payment plans, see [manage subscriptions](/admin-sdk/reseller/v1/how-tos/manage_subscriptions#create_subscription).\\ If you did not order the customer's account using the customer insert method, use the customer's `customerAuthToken` when creating a subscription for that customer. If transferring a G Suite subscription with an associated Google Drive or Google Vault subscription, use the [batch operation](/admin-sdk/reseller/v1/how-tos/batch.html) to transfer all of these subscriptions. For more information, see how to [transfer subscriptions](/admin-sdk/reseller/v1/how-tos/manage_subscriptions#transfer_a_subscription)."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:customerId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://reseller.googleapis.com/"
     "apps/reseller/v1/customers/{customerId}/subscriptions"
     #{:customerId}
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

(defn changeRenewalSettings$
  "https://developers.google.com/google-apps/reseller/api/reference/rest/v1/subscriptions/changeRenewalSettings
  
  Required parameters: customerId, subscriptionId
  
  Optional parameters: none
  
  Body: 
  
  {:renewalType string, :kind string}
  
  Updates a user license's renewal settings. This is applicable for accounts with annual commitment plans only. For more information, see the description in [manage subscriptions](/admin-sdk/reseller/v1/how-tos/manage_subscriptions#update_renewal)."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:customerId :subscriptionId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://reseller.googleapis.com/"
     "apps/reseller/v1/customers/{customerId}/subscriptions/{subscriptionId}/changeRenewalSettings"
     #{:customerId :subscriptionId}
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
  "https://developers.google.com/google-apps/reseller/api/reference/rest/v1/subscriptions/delete
  
  Required parameters: customerId, subscriptionId, deletionType
  
  Optional parameters: none
  
  Cancels, suspends, or transfers a subscription to direct."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:customerId :deletionType :subscriptionId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://reseller.googleapis.com/"
     "apps/reseller/v1/customers/{customerId}/subscriptions/{subscriptionId}"
     #{:customerId :deletionType :subscriptionId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn suspend$
  "https://developers.google.com/google-apps/reseller/api/reference/rest/v1/subscriptions/suspend
  
  Required parameters: customerId, subscriptionId
  
  Optional parameters: none
  
  Suspends an active subscription. You can use this method to suspend a paid subscription that is currently in the `ACTIVE` state. * For `FLEXIBLE` subscriptions, billing is paused. * For `ANNUAL_MONTHLY_PAY` or `ANNUAL_YEARLY_PAY` subscriptions: * Suspending the subscription does not change the renewal date that was originally committed to. * A suspended subscription does not renew. If you activate the subscription after the original renewal date, a new annual subscription will be created, starting on the day of activation. We strongly encourage you to suspend subscriptions only for short periods of time as suspensions over 60 days may result in the subscription being cancelled."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:customerId :subscriptionId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://reseller.googleapis.com/"
     "apps/reseller/v1/customers/{customerId}/subscriptions/{subscriptionId}/suspend"
     #{:customerId :subscriptionId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/google-apps/reseller/api/reference/rest/v1/subscriptions/list
  
  Required parameters: none
  
  Optional parameters: customerAuthToken, customerId, customerNamePrefix, maxResults, pageToken
  
  Lists of subscriptions managed by the reseller. The list can be all subscriptions, all of a customer's subscriptions, or all of a customer's transferable subscriptions. Optionally, this method can filter the response by a `customerNamePrefix`. For more information, see [manage subscriptions](/admin-sdk/reseller/v1/how-tos/manage_subscriptions)."
  {:scopes ["https://www.googleapis.com/auth/apps.order"
            "https://www.googleapis.com/auth/apps.order.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://reseller.googleapis.com/"
     "apps/reseller/v1/subscriptions"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn changePlan$
  "https://developers.google.com/google-apps/reseller/api/reference/rest/v1/subscriptions/changePlan
  
  Required parameters: customerId, subscriptionId
  
  Optional parameters: none
  
  Body: 
  
  {:kind string,
   :planName string,
   :seats {:numberOfSeats integer,
           :maximumNumberOfSeats integer,
           :licensedNumberOfSeats integer,
           :kind string},
   :purchaseOrderId string,
   :dealCode string}
  
  Updates a subscription plan. Use this method to update a plan for a 30-day trial or a flexible plan subscription to an annual commitment plan with monthly or yearly payments. How a plan is updated differs depending on the plan and the products. For more information, see the description in [manage subscriptions](/admin-sdk/reseller/v1/how-tos/manage_subscriptions#update_subscription_plan)."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:customerId :subscriptionId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://reseller.googleapis.com/"
     "apps/reseller/v1/customers/{customerId}/subscriptions/{subscriptionId}/changePlan"
     #{:customerId :subscriptionId}
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

(defn changeSeats$
  "https://developers.google.com/google-apps/reseller/api/reference/rest/v1/subscriptions/changeSeats
  
  Required parameters: customerId, subscriptionId
  
  Optional parameters: none
  
  Body: 
  
  {:numberOfSeats integer,
   :maximumNumberOfSeats integer,
   :licensedNumberOfSeats integer,
   :kind string}
  
  Updates a subscription's user license settings. For more information about updating an annual commitment plan or a flexible plan subscription’s licenses, see [Manage Subscriptions](/admin-sdk/reseller/v1/how-tos/manage_subscriptions#update_subscription_seat)."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:customerId :subscriptionId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://reseller.googleapis.com/"
     "apps/reseller/v1/customers/{customerId}/subscriptions/{subscriptionId}/changeSeats"
     #{:customerId :subscriptionId}
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

(defn activate$
  "https://developers.google.com/google-apps/reseller/api/reference/rest/v1/subscriptions/activate
  
  Required parameters: customerId, subscriptionId
  
  Optional parameters: none
  
  Activates a subscription previously suspended by the reseller. If you did not suspend the customer subscription and it is suspended for any other reason, such as for abuse or a pending ToS acceptance, this call will not reactivate the customer subscription."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:customerId :subscriptionId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://reseller.googleapis.com/"
     "apps/reseller/v1/customers/{customerId}/subscriptions/{subscriptionId}/activate"
     #{:customerId :subscriptionId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn startPaidService$
  "https://developers.google.com/google-apps/reseller/api/reference/rest/v1/subscriptions/startPaidService
  
  Required parameters: customerId, subscriptionId
  
  Optional parameters: none
  
  Immediately move a 30-day free trial subscription to a paid service subscription. This method is only applicable if a payment plan has already been set up for the 30-day trial subscription. For more information, see [manage subscriptions](/admin-sdk/reseller/v1/how-tos/manage_subscriptions#paid_service)."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:customerId :subscriptionId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://reseller.googleapis.com/"
     "apps/reseller/v1/customers/{customerId}/subscriptions/{subscriptionId}/startPaidService"
     #{:customerId :subscriptionId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
