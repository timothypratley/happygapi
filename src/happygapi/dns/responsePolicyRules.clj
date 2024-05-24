(ns happygapi.dns.responsePolicyRules
  "Cloud DNS API: responsePolicyRules.
  
  See: https://cloud.google.com/dns/docsdocs/reference/rest/v1/responsePolicyRules"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/responsePolicyRules/create
  
  Required parameters: project, responsePolicy
  
  Optional parameters: clientOperationId
  
  Body: 
  
  {:ruleName string,
   :dnsName string,
   :localData {:localDatas [ResourceRecordSet]},
   :behavior string,
   :kind string}
  
  Creates a new Response Policy Rule."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :responsePolicy})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dns.googleapis.com/"
     "dns/v1/projects/{project}/responsePolicies/{responsePolicy}/rules"
     #{:project :responsePolicy}
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

(defn get$
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/responsePolicyRules/get
  
  Required parameters: project, responsePolicy, responsePolicyRule
  
  Optional parameters: clientOperationId
  
  Fetches the representation of an existing Response Policy Rule."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/ndev.clouddns.readonly"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:project :responsePolicy :responsePolicyRule})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dns.googleapis.com/"
     "dns/v1/projects/{project}/responsePolicies/{responsePolicy}/rules/{responsePolicyRule}"
     #{:project :responsePolicy :responsePolicyRule}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/responsePolicyRules/delete
  
  Required parameters: project, responsePolicy, responsePolicyRule
  
  Optional parameters: clientOperationId
  
  Deletes a previously created Response Policy Rule."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:project :responsePolicy :responsePolicyRule})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dns.googleapis.com/"
     "dns/v1/projects/{project}/responsePolicies/{responsePolicy}/rules/{responsePolicyRule}"
     #{:project :responsePolicy :responsePolicyRule}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/responsePolicyRules/list
  
  Required parameters: project, responsePolicy
  
  Optional parameters: maxResults, pageToken
  
  Enumerates all Response Policy Rules associated with a project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/ndev.clouddns.readonly"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project :responsePolicy})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dns.googleapis.com/"
     "dns/v1/projects/{project}/responsePolicies/{responsePolicy}/rules"
     #{:project :responsePolicy}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/responsePolicyRules/patch
  
  Required parameters: project, responsePolicy, responsePolicyRule
  
  Optional parameters: clientOperationId
  
  Body: 
  
  {:ruleName string,
   :dnsName string,
   :localData {:localDatas [ResourceRecordSet]},
   :behavior string,
   :kind string}
  
  Applies a partial update to an existing Response Policy Rule."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:project :responsePolicy :responsePolicyRule})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dns.googleapis.com/"
     "dns/v1/projects/{project}/responsePolicies/{responsePolicy}/rules/{responsePolicyRule}"
     #{:project :responsePolicy :responsePolicyRule}
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

(defn update$
  "https://cloud.google.com/dns/docsapi/reference/rest/v1/responsePolicyRules/update
  
  Required parameters: project, responsePolicy, responsePolicyRule
  
  Optional parameters: clientOperationId
  
  Body: 
  
  {:ruleName string,
   :dnsName string,
   :localData {:localDatas [ResourceRecordSet]},
   :behavior string,
   :kind string}
  
  Updates an existing Response Policy Rule."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.clouddns.readwrite"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:project :responsePolicy :responsePolicyRule})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dns.googleapis.com/"
     "dns/v1/projects/{project}/responsePolicies/{responsePolicy}/rules/{responsePolicyRule}"
     #{:project :responsePolicy :responsePolicyRule}
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
