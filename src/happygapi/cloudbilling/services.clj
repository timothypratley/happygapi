(ns happygapi.cloudbilling.services
  "Cloud Billing API: services.
  Allows developers to manage billing for their Google Cloud Platform projects programmatically.
  See: https://cloud.google.com/billing/docs/apisapi/reference/rest/v1/services"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/billing/docs/apisapi/reference/rest/v1/services/list
  
  Required parameters: none
  
  Optional parameters: pageSize, pageToken
  
  Lists all public cloud services."
  {:scopes ["https://www.googleapis.com/auth/cloud-billing"
            "https://www.googleapis.com/auth/cloud-billing.readonly"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudbilling.googleapis.com/"
     "v1/services"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn skus-list$
  "https://cloud.google.com/billing/docs/apisapi/reference/rest/v1/services/skus/list
  
  Required parameters: parent
  
  Optional parameters: startTime, endTime, currencyCode, pageSize, pageToken
  
  Lists all publicly available SKUs for a given cloud service."
  {:scopes ["https://www.googleapis.com/auth/cloud-billing"
            "https://www.googleapis.com/auth/cloud-billing.readonly"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudbilling.googleapis.com/"
     "v1/{+parent}/skus"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
