(ns happygapi.billingbudgets.billingAccounts
  "Cloud Billing Budget API
  The Cloud Billing Budget API stores Cloud Billing budgets, which define a budget plan and the rules to execute as spend is tracked against that plan.
  See: https://cloud.google.com/billing/docs/how-to/budget-api-overview"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn budgets-delete$
  "Required parameters: name
  
  Deletes a budget. Returns successfully if already deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://billingbudgets.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn budgets-patch$
  "Required parameters: name
  
  Updates a budget and returns the updated budget."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://billingbudgets.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn budgets-get$
  "Required parameters: name
  
  Returns a budget."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://billingbudgets.googleapis.com/"
     "v1beta1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn budgets-list$
  "Required parameters: parent
  
  Returns a list of budgets for a billing account."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://billingbudgets.googleapis.com/"
     "v1beta1/{+parent}/budgets"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn budgets-create$
  "Required parameters: parent
  
  Creates a new budget. See
  <a href=\"https://cloud.google.com/billing/quotas\">Quotas and limits</a>
  for more information on the limits of the number of budgets you can create."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://billingbudgets.googleapis.com/"
     "v1beta1/{+parent}/budgets"
     #{"parent"}
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
