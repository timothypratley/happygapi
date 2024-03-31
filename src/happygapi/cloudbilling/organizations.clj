(ns happygapi.cloudbilling.organizations
  "Cloud Billing API: organizations.
  Allows developers to manage billing for their Google Cloud Platform projects programmatically.
  See: https://cloud.google.com/billing/docs/apisapi/reference/rest/v1/organizations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn billingAccounts-list$
  "https://cloud.google.com/billing/docs/apisapi/reference/rest/v1/organizations/billingAccounts/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists the billing accounts that the current authenticated user has permission to [view](https://cloud.google.com/billing/docs/how-to/billing-access)."
  {:scopes ["https://www.googleapis.com/auth/cloud-billing"
            "https://www.googleapis.com/auth/cloud-billing.readonly"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudbilling.googleapis.com/"
     "v1/{+parent}/billingAccounts"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn billingAccounts-create$
  "https://cloud.google.com/billing/docs/apisapi/reference/rest/v1/organizations/billingAccounts/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :open boolean,
   :displayName string,
   :masterBillingAccount string,
   :parent string}
  
  This method creates [billing subaccounts](https://cloud.google.com/billing/docs/concepts#subaccounts). Google Cloud resellers should use the Channel Services APIs, [accounts.customers.create](https://cloud.google.com/channel/docs/reference/rest/v1/accounts.customers/create) and [accounts.customers.entitlements.create](https://cloud.google.com/channel/docs/reference/rest/v1/accounts.customers.entitlements/create). When creating a subaccount, the current authenticated user must have the `billing.accounts.update` IAM permission on the parent account, which is typically given to billing account [administrators](https://cloud.google.com/billing/docs/how-to/billing-access). This method will return an error if the parent account has not been provisioned for subaccounts."
  {:scopes ["https://www.googleapis.com/auth/cloud-billing"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudbilling.googleapis.com/"
     "v1/{+parent}/billingAccounts"
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

(defn billingAccounts-move$
  "https://cloud.google.com/billing/docs/apisapi/reference/rest/v1/organizations/billingAccounts/move
  
  Required parameters: destinationParent, name
  
  Optional parameters: none
  
  Changes which parent organization a billing account belongs to."
  {:scopes ["https://www.googleapis.com/auth/cloud-billing"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:destinationParent :name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudbilling.googleapis.com/"
     "v1/{+destinationParent}/{+name}:move"
     #{:destinationParent :name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
