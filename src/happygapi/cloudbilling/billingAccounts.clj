(ns happygapi.cloudbilling.billingAccounts
  "Cloud Billing API
  Allows developers to manage billing for their Google Cloud Platform projects
      programmatically.
  See: https://cloud.google.com/billing/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "cloudbilling_schema.edn"))))

(defn get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets information about a billing account. The current authenticated user
  must be a [viewer of the billing
  account](https://cloud.google.com/billing/docs/how-to/billing-access)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudbilling.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "Required parameters: name
  
  Optional parameters: updateMask
  
  Updates a billing account's fields.
  Currently the only field that can be edited is `display_name`.
  The current authenticated user must have the `billing.accounts.update`
  IAM permission, which is typically given to the
  [administrator](https://cloud.google.com/billing/docs/how-to/billing-access)
  of the billing account."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudbilling.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn testIamPermissions$
  "Required parameters: resource
  
  Optional parameters: none
  
  Tests the access control policy for a billing account. This method takes
  the resource and a set of permissions as input and returns the subset of
  the input permissions that the caller is allowed for that resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudbilling.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{"resource"}
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
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists the billing accounts that the current authenticated user has
  permission to
  [view](https://cloud.google.com/billing/docs/how-to/billing-access)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudbilling.googleapis.com/"
     "v1/billingAccounts"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn create$
  "Required parameters: none
  
  Optional parameters: none
  
  Creates a billing account.
  This method can only be used to create
  [billing subaccounts](https://cloud.google.com/billing/docs/concepts)
  by GCP resellers.
  When creating a subaccount, the current authenticated user must have the
  `billing.accounts.update` IAM permission on the master account, which is
  typically given to billing account
  [administrators](https://cloud.google.com/billing/docs/how-to/billing-access).
  This method will return an error if the master account has not been
  provisioned as a reseller account."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudbilling.googleapis.com/"
     "v1/billingAccounts"
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

(defn setIamPolicy$
  "Required parameters: resource
  
  Optional parameters: none
  
  Sets the access control policy for a billing account. Replaces any existing
  policy.
  The caller must have the `billing.accounts.setIamPolicy` permission on the
  account, which is often given to billing account
  [administrators](https://cloud.google.com/billing/docs/how-to/billing-access)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudbilling.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{"resource"}
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

(defn getIamPolicy$
  "Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a billing account.
  The caller must have the `billing.accounts.getIamPolicy` permission on the
  account, which is often given to billing account
  [viewers](https://cloud.google.com/billing/docs/how-to/billing-access)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudbilling.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn projects-list$
  "Required parameters: name
  
  Optional parameters: pageToken, pageSize
  
  Lists the projects associated with a billing account. The current
  authenticated user must have the `billing.resourceAssociations.list` IAM
  permission, which is often given to billing account
  [viewers](https://cloud.google.com/billing/docs/how-to/billing-access)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudbilling.googleapis.com/"
     "v1/{+name}/projects"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
