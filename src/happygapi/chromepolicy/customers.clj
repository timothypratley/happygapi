(ns happygapi.chromepolicy.customers
  "Chrome Policy API: customers.
  The Chrome Policy API is a suite of services that allows Chrome administrators to control the policies applied to their managed Chrome OS devices and Chrome browsers.
  See: http://developers.google.com/chrome/policyapi/reference/rest/v1/customers"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn policySchemas-get$
  "http://developers.google.com/chrome/policyapi/reference/rest/v1/customers/policySchemas/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get a specific policy schema for a customer by its resource name."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.policy"
            "https://www.googleapis.com/auth/chrome.management.policy.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chromepolicy.googleapis.com/"
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

(defn policySchemas-list$
  "http://developers.google.com/chrome/policyapi/reference/rest/v1/customers/policySchemas/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, filter, pageSize
  
  Gets a list of policy schemas that match a specified filter value for a given customer."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.policy"
            "https://www.googleapis.com/auth/chrome.management.policy.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://chromepolicy.googleapis.com/"
     "v1/{+parent}/policySchemas"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn policies-resolve$
  "http://developers.google.com/chrome/policyapi/reference/rest/v1/customers/policies/resolve
  
  Required parameters: customer
  
  Optional parameters: none
  
  Body: 
  
  {:policyTargetKey {:targetResource string, :additionalTargetKeys {}},
   :pageSize integer,
   :policySchemaFilter string,
   :pageToken string}
  
  Gets the resolved policy values for a list of policies that match a search query."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.policy"
            "https://www.googleapis.com/auth/chrome.management.policy.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:customer})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://chromepolicy.googleapis.com/"
     "v1/{+customer}/policies:resolve"
     #{:customer}
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

(defn policies-orgunits-batchModify$
  "http://developers.google.com/chrome/policyapi/reference/rest/v1/customers/policies/orgunits/batchModify
  
  Required parameters: customer
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:policyValue GoogleChromePolicyV1PolicyValue,
               :policyTargetKey GoogleChromePolicyV1PolicyTargetKey,
               :updateMask string}]}
  
  Modify multiple policy values that are applied to a specific org unit. All targets must have the same target format. That is to say that they must point to the same target resource and must have the same keys specified in `additionalTargetKeyNames`. On failure the request will return the error details as part of the google.rpc.Status."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.policy"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:customer})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://chromepolicy.googleapis.com/"
     "v1/{+customer}/policies/orgunits:batchModify"
     #{:customer}
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

(defn policies-orgunits-batchInherit$
  "http://developers.google.com/chrome/policyapi/reference/rest/v1/customers/policies/orgunits/batchInherit
  
  Required parameters: customer
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:policySchema string,
               :policyTargetKey GoogleChromePolicyV1PolicyTargetKey}]}
  
  Modify multiple policy values that are applied to a specific org unit so that they now inherit the value from a parent (if applicable). All targets must have the same target format. That is to say that they must point to the same target resource and must have the same keys specified in `additionalTargetKeyNames`. On failure the request will return the error details as part of the google.rpc.Status."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.policy"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:customer})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://chromepolicy.googleapis.com/"
     "v1/{+customer}/policies/orgunits:batchInherit"
     #{:customer}
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
