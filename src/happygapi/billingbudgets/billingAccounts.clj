(ns happygapi.billingbudgets.billingAccounts
  "Cloud Billing Budget API: billingAccounts.
  The Cloud Billing Budget API stores Cloud Billing budgets, which define a budget plan and the rules to execute as spend is tracked against that plan.
  See: https://cloud.google.com/billing/docs/how-to/budget-api-overviewapi/reference/rest/v1/billingAccounts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn budgets-create$
  "https://cloud.google.com/billing/docs/how-to/budget-api-overviewapi/reference/rest/v1/billingAccounts/budgets/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:displayName string,
   :notificationsRule {:disableDefaultIamRecipients boolean,
                       :monitoringNotificationChannels [string],
                       :schemaVersion string,
                       :pubsubTopic string},
   :thresholdRules [{:spendBasis string, :thresholdPercent number}],
   :budgetFilter {:projects [string],
                  :services [string],
                  :labels {},
                  :subaccounts [string],
                  :creditTypesTreatment string},
   :name string,
   :amount {:specifiedAmount GoogleTypeMoney,
            :lastPeriodAmount GoogleCloudBillingBudgetsV1LastPeriodAmount},
   :etag string}
  
  Creates a new budget. See [Quotas and limits](https://cloud.google.com/billing/quotas) for more information on the limits of the number of budgets you can create."
  {:scopes ["https://www.googleapis.com/auth/cloud-billing"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://billingbudgets.googleapis.com/"
     "v1/{+parent}/budgets"
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

(defn budgets-patch$
  "https://cloud.google.com/billing/docs/how-to/budget-api-overviewapi/reference/rest/v1/billingAccounts/budgets/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:displayName string,
   :notificationsRule {:disableDefaultIamRecipients boolean,
                       :monitoringNotificationChannels [string],
                       :schemaVersion string,
                       :pubsubTopic string},
   :thresholdRules [{:spendBasis string, :thresholdPercent number}],
   :budgetFilter {:projects [string],
                  :services [string],
                  :labels {},
                  :subaccounts [string],
                  :creditTypesTreatment string},
   :name string,
   :amount {:specifiedAmount GoogleTypeMoney,
            :lastPeriodAmount GoogleCloudBillingBudgetsV1LastPeriodAmount},
   :etag string}
  
  Updates a budget and returns the updated budget. WARNING: There are some fields exposed on the Google Cloud Console that aren't available on this API. Budget fields that are not exposed in this API will not be changed by this method."
  {:scopes ["https://www.googleapis.com/auth/cloud-billing"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://billingbudgets.googleapis.com/"
     "v1/{+name}"
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

(defn budgets-delete$
  "https://cloud.google.com/billing/docs/how-to/budget-api-overviewapi/reference/rest/v1/billingAccounts/budgets/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a budget. Returns successfully if already deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-billing"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://billingbudgets.googleapis.com/"
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

(defn budgets-list$
  "https://cloud.google.com/billing/docs/how-to/budget-api-overviewapi/reference/rest/v1/billingAccounts/budgets/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Returns a list of budgets for a billing account. WARNING: There are some fields exposed on the Google Cloud Console that aren't available on this API. When reading from the API, you will not see these fields in the return value, though they may have been set in the Cloud Console."
  {:scopes ["https://www.googleapis.com/auth/cloud-billing"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://billingbudgets.googleapis.com/"
     "v1/{+parent}/budgets"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn budgets-get$
  "https://cloud.google.com/billing/docs/how-to/budget-api-overviewapi/reference/rest/v1/billingAccounts/budgets/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns a budget. WARNING: There are some fields exposed on the Google Cloud Console that aren't available on this API. When reading from the API, you will not see these fields in the return value, though they may have been set in the Cloud Console."
  {:scopes ["https://www.googleapis.com/auth/cloud-billing"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://billingbudgets.googleapis.com/"
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
