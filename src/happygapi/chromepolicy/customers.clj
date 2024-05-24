(ns happygapi.chromepolicy.customers
  "Chrome Policy API: customers.
  The Chrome Policy API is a suite of services that allows Chrome administrators to control the policies applied to their managed Chrome OS devices and Chrome browsers.
  See: http://developers.google.com/chrome/policydocs/reference/rest/v1/customers"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn policySchemas-list$
  "http://developers.google.com/chrome/policyapi/reference/rest/v1/customers/policySchemas/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, filter, pageToken
  
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

(defn policies-resolve$
  "http://developers.google.com/chrome/policyapi/reference/rest/v1/customers/policies/resolve
  
  Required parameters: customer
  
  Optional parameters: none
  
  Body: 
  
  {:pageToken string,
   :policyTargetKey {:additionalTargetKeys {}, :targetResource string},
   :policySchemaFilter string,
   :pageSize integer}
  
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

(defn policies-networks-removeCertificate$
  "http://developers.google.com/chrome/policyapi/reference/rest/v1/customers/policies/networks/removeCertificate
  
  Required parameters: customer
  
  Optional parameters: none
  
  Body: 
  
  {:networkId string, :targetResource string}
  
  Remove an existing certificate by guid."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.policy"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:customer})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://chromepolicy.googleapis.com/"
     "v1/{+customer}/policies/networks:removeCertificate"
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

(defn policies-networks-defineNetwork$
  "http://developers.google.com/chrome/policyapi/reference/rest/v1/customers/policies/networks/defineNetwork
  
  Required parameters: customer
  
  Optional parameters: none
  
  Body: 
  
  {:settings [{:policySchema string, :value {}}],
   :targetResource string,
   :name string}
  
  Define a new network."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.policy"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:customer})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://chromepolicy.googleapis.com/"
     "v1/{+customer}/policies/networks:defineNetwork"
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

(defn policies-networks-defineCertificate$
  "http://developers.google.com/chrome/policyapi/reference/rest/v1/customers/policies/networks/defineCertificate
  
  Required parameters: customer
  
  Optional parameters: none
  
  Body: 
  
  {:settings [{:policySchema string, :value {}}],
   :ceritificateName string,
   :certificate string,
   :targetResource string}
  
  Creates a certificate at a specified OU for a customer."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.policy"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:customer})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://chromepolicy.googleapis.com/"
     "v1/{+customer}/policies/networks:defineCertificate"
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

(defn policies-networks-removeNetwork$
  "http://developers.google.com/chrome/policyapi/reference/rest/v1/customers/policies/networks/removeNetwork
  
  Required parameters: customer
  
  Optional parameters: none
  
  Body: 
  
  {:targetResource string, :networkId string}
  
  Remove an existing network by guid."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.policy"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:customer})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://chromepolicy.googleapis.com/"
     "v1/{+customer}/policies/networks:removeNetwork"
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
  
  {:requests [{:policyTargetKey GoogleChromePolicyVersionsV1PolicyTargetKey,
               :policySchema string}]}
  
  Modify multiple policy values that are applied to a specific org unit so that they now inherit the value from a parent (if applicable). All targets must have the same target format. That is to say that they must point to the same target resource and must have the same keys specified in `additionalTargetKeyNames`, though the values for those keys may be different. On failure the request will return the error details as part of the google.rpc.Status."
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

(defn policies-orgunits-batchModify$
  "http://developers.google.com/chrome/policyapi/reference/rest/v1/customers/policies/orgunits/batchModify
  
  Required parameters: customer
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:updateMask string,
               :policyTargetKey GoogleChromePolicyVersionsV1PolicyTargetKey,
               :policyValue GoogleChromePolicyVersionsV1PolicyValue}]}
  
  Modify multiple policy values that are applied to a specific org unit. All targets must have the same target format. That is to say that they must point to the same target resource and must have the same keys specified in `additionalTargetKeyNames`, though the values for those keys may be different. On failure the request will return the error details as part of the google.rpc.Status."
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

(defn policies-groups-batchModify$
  "http://developers.google.com/chrome/policyapi/reference/rest/v1/customers/policies/groups/batchModify
  
  Required parameters: customer
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:updateMask string,
               :policyValue GoogleChromePolicyVersionsV1PolicyValue,
               :policyTargetKey GoogleChromePolicyVersionsV1PolicyTargetKey}]}
  
  Modify multiple policy values that are applied to a specific group. All targets must have the same target format. That is to say that they must point to the same target resource and must have the same keys specified in `additionalTargetKeyNames`, though the values for those keys may be different. On failure the request will return the error details as part of the google.rpc.Status."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.policy"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:customer})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://chromepolicy.googleapis.com/"
     "v1/{+customer}/policies/groups:batchModify"
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

(defn policies-groups-listGroupPriorityOrdering$
  "http://developers.google.com/chrome/policyapi/reference/rest/v1/customers/policies/groups/listGroupPriorityOrdering
  
  Required parameters: customer
  
  Optional parameters: none
  
  Body: 
  
  {:policySchema string,
   :policyNamespace string,
   :policyTargetKey {:additionalTargetKeys {}, :targetResource string}}
  
  Retrieve a group priority ordering for an app. The target app must be supplied in `additionalTargetKeyNames` in the PolicyTargetKey. On failure the request will return the error details as part of the google.rpc.Status."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.policy"
            "https://www.googleapis.com/auth/chrome.management.policy.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:customer})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://chromepolicy.googleapis.com/"
     "v1/{+customer}/policies/groups:listGroupPriorityOrdering"
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

(defn policies-groups-updateGroupPriorityOrdering$
  "http://developers.google.com/chrome/policyapi/reference/rest/v1/customers/policies/groups/updateGroupPriorityOrdering
  
  Required parameters: customer
  
  Optional parameters: none
  
  Body: 
  
  {:groupIds [string],
   :policyNamespace string,
   :policyTargetKey {:additionalTargetKeys {}, :targetResource string},
   :policySchema string}
  
  Update a group priority ordering for an app. The target app must be supplied in `additionalTargetKeyNames` in the PolicyTargetKey. On failure the request will return the error details as part of the google.rpc.Status."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.policy"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:customer})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://chromepolicy.googleapis.com/"
     "v1/{+customer}/policies/groups:updateGroupPriorityOrdering"
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

(defn policies-groups-batchDelete$
  "http://developers.google.com/chrome/policyapi/reference/rest/v1/customers/policies/groups/batchDelete
  
  Required parameters: customer
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:policyTargetKey GoogleChromePolicyVersionsV1PolicyTargetKey,
               :policySchema string}]}
  
  Delete multiple policy values that are applied to a specific group. All targets must have the same target format. That is to say that they must point to the same target resource and must have the same keys specified in `additionalTargetKeyNames`, though the values for those keys may be different. On failure the request will return the error details as part of the google.rpc.Status."
  {:scopes ["https://www.googleapis.com/auth/chrome.management.policy"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:customer})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://chromepolicy.googleapis.com/"
     "v1/{+customer}/policies/groups:batchDelete"
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
