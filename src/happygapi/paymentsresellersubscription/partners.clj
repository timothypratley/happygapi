(ns happygapi.paymentsresellersubscription.partners
  "Payments Reseller Subscription API: partners.
  
  See: https://developers.google.com/payments/reseller/subscription/api/reference/rest/v1/partners"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn products-list$
  "https://developers.google.com/payments/reseller/subscription/api/reference/rest/v1/partners/products/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Used by partners to list products that can be resold to their customers. It should be called directly by the partner using service accounts."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://paymentsresellersubscription.googleapis.com/"
     "v1/{+parent}/products"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn subscriptions-provision$
  "https://developers.google.com/payments/reseller/subscription/api/reference/rest/v1/partners/subscriptions/provision
  
  Required parameters: parent
  
  Optional parameters: subscriptionId
  
  Body: 
  
  {:promotions [string],
   :redirectUri string,
   :endUserEntitled boolean,
   :cancellationDetails {:reason string},
   :freeTrialEndTime string,
   :cycleEndTime string,
   :products [string],
   :name string,
   :upgradeDowngradeDetails {:previousSubscriptionId string,
                             :billingCycleSpec string},
   :createTime string,
   :processingState string,
   :state string,
   :updateTime string,
   :partnerUserToken string,
   :serviceLocation {:postalCode string, :regionCode string}}
  
  Used by partners to provision a subscription for their customers. This creates a subscription without associating it with the end user account. EntitleSubscription must be called separately using OAuth in order for the end user account to be associated with the subscription. It should be called directly by the partner using service accounts."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://paymentsresellersubscription.googleapis.com/"
     "v1/{+parent}/subscriptions:provision"
     #{:parent}
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

(defn subscriptions-extend$
  "https://developers.google.com/payments/reseller/subscription/api/reference/rest/v1/partners/subscriptions/extend
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:requestId string,
   :extension {:duration GoogleCloudPaymentsResellerSubscriptionV1Duration,
               :partnerUserToken string}}
  
  Used by partners to extend a subscription service for their customers. It should be called directly by the partner using service accounts."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://paymentsresellersubscription.googleapis.com/"
     "v1/{+name}:extend"
     #{:name}
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

(defn subscriptions-undoCancel$
  "https://developers.google.com/payments/reseller/subscription/api/reference/rest/v1/partners/subscriptions/undoCancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Used by partners to revoke the pending cancellation of a subscription, which is currently in `STATE_CANCEL_AT_END_OF_CYCLE` state. If the subscription is already cancelled, the request will fail. It should be called directly by the partner using service accounts."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://paymentsresellersubscription.googleapis.com/"
     "v1/{+name}:undoCancel"
     #{:name}
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

(defn subscriptions-create$
  "https://developers.google.com/payments/reseller/subscription/api/reference/rest/v1/partners/subscriptions/create
  
  Required parameters: parent
  
  Optional parameters: subscriptionId
  
  Body: 
  
  {:promotions [string],
   :redirectUri string,
   :endUserEntitled boolean,
   :cancellationDetails {:reason string},
   :freeTrialEndTime string,
   :cycleEndTime string,
   :products [string],
   :name string,
   :upgradeDowngradeDetails {:previousSubscriptionId string,
                             :billingCycleSpec string},
   :createTime string,
   :processingState string,
   :state string,
   :updateTime string,
   :partnerUserToken string,
   :serviceLocation {:postalCode string, :regionCode string}}
  
  Used by partners to create a subscription for their customers. The created subscription is associated with the end user inferred from the end user credentials. This API must be authorized by the end user using OAuth."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://paymentsresellersubscription.googleapis.com/"
     "v1/{+parent}/subscriptions"
     #{:parent}
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
  "https://developers.google.com/payments/reseller/subscription/api/reference/rest/v1/partners/subscriptions/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Used by partners to get a subscription by id. It should be called directly by the partner using service accounts."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://paymentsresellersubscription.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn subscriptions-entitle$
  "https://developers.google.com/payments/reseller/subscription/api/reference/rest/v1/partners/subscriptions/entitle
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Used by partners to entitle a previously provisioned subscription to the current end user. The end user identity is inferred from the authorized credential of the request. This API must be authorized by the end user using OAuth."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://paymentsresellersubscription.googleapis.com/"
     "v1/{+name}:entitle"
     #{:name}
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
  "https://developers.google.com/payments/reseller/subscription/api/reference/rest/v1/partners/subscriptions/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:cancelImmediately boolean, :cancellationReason string}
  
  Used by partners to cancel a subscription service either immediately or by the end of the current billing cycle for their customers. It should be called directly by the partner using service accounts."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://paymentsresellersubscription.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
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

(defn promotions-list$
  "https://developers.google.com/payments/reseller/subscription/api/reference/rest/v1/partners/promotions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Used by partners to list promotions, such as free trial, that can be applied on subscriptions. It should be called directly by the partner using service accounts."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://paymentsresellersubscription.googleapis.com/"
     "v1/{+parent}/promotions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
