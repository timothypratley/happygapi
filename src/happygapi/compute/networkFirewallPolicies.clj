(ns happygapi.compute.networkFirewallPolicies
  "Compute Engine API: networkFirewallPolicies.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/networkFirewallPolicies"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn cloneRules$
  "https://cloud.google.com/compute/api/reference/rest/v1/networkFirewallPolicies/cloneRules
  
  Required parameters: firewallPolicy, project
  
  Optional parameters: requestId, sourceFirewallPolicy
  
  Copies rules to the specified firewall policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project :firewallPolicy})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/firewallPolicies/{firewallPolicy}/cloneRules"
     #{:project :firewallPolicy}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn removeRule$
  "https://cloud.google.com/compute/api/reference/rest/v1/networkFirewallPolicies/removeRule
  
  Required parameters: firewallPolicy, project
  
  Optional parameters: priority, requestId
  
  Deletes a rule of the specified priority."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project :firewallPolicy})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/firewallPolicies/{firewallPolicy}/removeRule"
     #{:project :firewallPolicy}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/networkFirewallPolicies/get
  
  Required parameters: firewallPolicy, project
  
  Optional parameters: none
  
  Returns the specified network firewall policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project :firewallPolicy})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/firewallPolicies/{firewallPolicy}"
     #{:project :firewallPolicy}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setIamPolicy$
  "https://cloud.google.com/compute/api/reference/rest/v1/networkFirewallPolicies/setIamPolicy
  
  Required parameters: project, resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :rules [Rule],
            :etag string},
   :bindings [{:role string,
               :members [string],
               :condition Expr,
               :bindingId string}],
   :etag string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/firewallPolicies/{resource}/setIamPolicy"
     #{:project :resource}
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

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/networkFirewallPolicies/insert
  
  Required parameters: project
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :ruleTupleCount integer,
   :parent string,
   :creationTimestamp string,
   :displayName string,
   :name string,
   :selfLink string,
   :associations [{:name string,
                   :attachmentTarget string,
                   :firewallPolicyId string,
                   :shortName string,
                   :displayName string}],
   :rules [{:description string,
            :securityProfileGroup string,
            :ruleTupleCount integer,
            :disabled boolean,
            :ruleName string,
            :tlsInspect boolean,
            :targetSecureTags [FirewallPolicyRuleSecureTag],
            :enableLogging boolean,
            :priority integer,
            :kind string,
            :targetResources [string],
            :targetServiceAccounts [string],
            :action string,
            :direction string,
            :match FirewallPolicyRuleMatcher}],
   :region string,
   :shortName string,
   :selfLinkWithId string,
   :id string,
   :kind string,
   :fingerprint string}
  
  Creates a new policy in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/firewallPolicies"
     #{:project}
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

(defn patch$
  "https://cloud.google.com/compute/api/reference/rest/v1/networkFirewallPolicies/patch
  
  Required parameters: firewallPolicy, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :ruleTupleCount integer,
   :parent string,
   :creationTimestamp string,
   :displayName string,
   :name string,
   :selfLink string,
   :associations [{:name string,
                   :attachmentTarget string,
                   :firewallPolicyId string,
                   :shortName string,
                   :displayName string}],
   :rules [{:description string,
            :securityProfileGroup string,
            :ruleTupleCount integer,
            :disabled boolean,
            :ruleName string,
            :tlsInspect boolean,
            :targetSecureTags [FirewallPolicyRuleSecureTag],
            :enableLogging boolean,
            :priority integer,
            :kind string,
            :targetResources [string],
            :targetServiceAccounts [string],
            :action string,
            :direction string,
            :match FirewallPolicyRuleMatcher}],
   :region string,
   :shortName string,
   :selfLinkWithId string,
   :id string,
   :kind string,
   :fingerprint string}
  
  Patches the specified policy with the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :firewallPolicy})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/firewallPolicies/{firewallPolicy}"
     #{:project :firewallPolicy}
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

(defn testIamPermissions$
  "https://cloud.google.com/compute/api/reference/rest/v1/networkFirewallPolicies/testIamPermissions
  
  Required parameters: project, resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/firewallPolicies/{resource}/testIamPermissions"
     #{:project :resource}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/networkFirewallPolicies/delete
  
  Required parameters: firewallPolicy, project
  
  Optional parameters: requestId
  
  Deletes the specified policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project :firewallPolicy})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/firewallPolicies/{firewallPolicy}"
     #{:project :firewallPolicy}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn removeAssociation$
  "https://cloud.google.com/compute/api/reference/rest/v1/networkFirewallPolicies/removeAssociation
  
  Required parameters: firewallPolicy, project
  
  Optional parameters: name, requestId
  
  Removes an association for the specified firewall policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project :firewallPolicy})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/firewallPolicies/{firewallPolicy}/removeAssociation"
     #{:project :firewallPolicy}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getIamPolicy$
  "https://cloud.google.com/compute/api/reference/rest/v1/networkFirewallPolicies/getIamPolicy
  
  Required parameters: project, resource
  
  Optional parameters: optionsRequestedPolicyVersion
  
  Gets the access control policy for a resource. May be empty if no such policy or resource exists."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project :resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/firewallPolicies/{resource}/getIamPolicy"
     #{:project :resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patchRule$
  "https://cloud.google.com/compute/api/reference/rest/v1/networkFirewallPolicies/patchRule
  
  Required parameters: firewallPolicy, project
  
  Optional parameters: priority, requestId
  
  Body: 
  
  {:description string,
   :securityProfileGroup string,
   :ruleTupleCount integer,
   :disabled boolean,
   :ruleName string,
   :tlsInspect boolean,
   :targetSecureTags [{:name string, :state string}],
   :enableLogging boolean,
   :priority integer,
   :kind string,
   :targetResources [string],
   :targetServiceAccounts [string],
   :action string,
   :direction string,
   :match {:destFqdns [string],
           :srcThreatIntelligences [string],
           :srcSecureTags [FirewallPolicyRuleSecureTag],
           :srcRegionCodes [string],
           :srcFqdns [string],
           :destRegionCodes [string],
           :layer4Configs [FirewallPolicyRuleMatcherLayer4Config],
           :srcAddressGroups [string],
           :destIpRanges [string],
           :destThreatIntelligences [string],
           :destAddressGroups [string],
           :srcIpRanges [string]}}
  
  Patches a rule of the specified priority."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :firewallPolicy})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/firewallPolicies/{firewallPolicy}/patchRule"
     #{:project :firewallPolicy}
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

(defn addRule$
  "https://cloud.google.com/compute/api/reference/rest/v1/networkFirewallPolicies/addRule
  
  Required parameters: firewallPolicy, project
  
  Optional parameters: maxPriority, minPriority, requestId
  
  Body: 
  
  {:description string,
   :securityProfileGroup string,
   :ruleTupleCount integer,
   :disabled boolean,
   :ruleName string,
   :tlsInspect boolean,
   :targetSecureTags [{:name string, :state string}],
   :enableLogging boolean,
   :priority integer,
   :kind string,
   :targetResources [string],
   :targetServiceAccounts [string],
   :action string,
   :direction string,
   :match {:destFqdns [string],
           :srcThreatIntelligences [string],
           :srcSecureTags [FirewallPolicyRuleSecureTag],
           :srcRegionCodes [string],
           :srcFqdns [string],
           :destRegionCodes [string],
           :layer4Configs [FirewallPolicyRuleMatcherLayer4Config],
           :srcAddressGroups [string],
           :destIpRanges [string],
           :destThreatIntelligences [string],
           :destAddressGroups [string],
           :srcIpRanges [string]}}
  
  Inserts a rule into a firewall policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :firewallPolicy})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/firewallPolicies/{firewallPolicy}/addRule"
     #{:project :firewallPolicy}
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

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/networkFirewallPolicies/list
  
  Required parameters: project
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Lists all the policies that have been configured for the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/firewallPolicies"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getRule$
  "https://cloud.google.com/compute/api/reference/rest/v1/networkFirewallPolicies/getRule
  
  Required parameters: firewallPolicy, project
  
  Optional parameters: priority
  
  Gets a rule of the specified priority."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project :firewallPolicy})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/firewallPolicies/{firewallPolicy}/getRule"
     #{:project :firewallPolicy}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn addAssociation$
  "https://cloud.google.com/compute/api/reference/rest/v1/networkFirewallPolicies/addAssociation
  
  Required parameters: firewallPolicy, project
  
  Optional parameters: replaceExistingAssociation, requestId
  
  Body: 
  
  {:name string,
   :attachmentTarget string,
   :firewallPolicyId string,
   :shortName string,
   :displayName string}
  
  Inserts an association for the specified firewall policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :firewallPolicy})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/firewallPolicies/{firewallPolicy}/addAssociation"
     #{:project :firewallPolicy}
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

(defn getAssociation$
  "https://cloud.google.com/compute/api/reference/rest/v1/networkFirewallPolicies/getAssociation
  
  Required parameters: firewallPolicy, project
  
  Optional parameters: name
  
  Gets an association with the specified name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project :firewallPolicy})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/firewallPolicies/{firewallPolicy}/getAssociation"
     #{:project :firewallPolicy}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
