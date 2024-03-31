(ns happygapi.compute.regionNetworkFirewallPolicies
  "Compute Engine API: regionNetworkFirewallPolicies.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/regionNetworkFirewallPolicies"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn cloneRules$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionNetworkFirewallPolicies/cloneRules
  
  Required parameters: firewallPolicy, project, region
  
  Optional parameters: requestId, sourceFirewallPolicy
  
  Copies rules to the specified network firewall policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:region :project :firewallPolicy})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/firewallPolicies/{firewallPolicy}/cloneRules"
     #{:region :project :firewallPolicy}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn removeRule$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionNetworkFirewallPolicies/removeRule
  
  Required parameters: firewallPolicy, project, region
  
  Optional parameters: priority, requestId
  
  Deletes a rule of the specified priority."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:region :project :firewallPolicy})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/firewallPolicies/{firewallPolicy}/removeRule"
     #{:region :project :firewallPolicy}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionNetworkFirewallPolicies/get
  
  Required parameters: firewallPolicy, project, region
  
  Optional parameters: none
  
  Returns the specified network firewall policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:region :project :firewallPolicy})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/firewallPolicies/{firewallPolicy}"
     #{:region :project :firewallPolicy}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setIamPolicy$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionNetworkFirewallPolicies/setIamPolicy
  
  Required parameters: project, region, resource
  
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
  {:pre [(util/has-keys? parameters #{:region :project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/firewallPolicies/{resource}/setIamPolicy"
     #{:region :project :resource}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/regionNetworkFirewallPolicies/insert
  
  Required parameters: project, region
  
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
  
  Creates a new network firewall policy in the specified project and region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/firewallPolicies"
     #{:region :project}
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

(defn getEffectiveFirewalls$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionNetworkFirewallPolicies/getEffectiveFirewalls
  
  Required parameters: network, project, region
  
  Optional parameters: none
  
  Returns the effective firewalls on a given network."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project :network})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/firewallPolicies/getEffectiveFirewalls"
     #{:region :project :network}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionNetworkFirewallPolicies/patch
  
  Required parameters: firewallPolicy, project, region
  
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
  
  Patches the specified network firewall policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:region :project :firewallPolicy})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/firewallPolicies/{firewallPolicy}"
     #{:region :project :firewallPolicy}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/regionNetworkFirewallPolicies/testIamPermissions
  
  Required parameters: project, region, resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/firewallPolicies/{resource}/testIamPermissions"
     #{:region :project :resource}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/regionNetworkFirewallPolicies/delete
  
  Required parameters: firewallPolicy, project, region
  
  Optional parameters: requestId
  
  Deletes the specified network firewall policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:region :project :firewallPolicy})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/firewallPolicies/{firewallPolicy}"
     #{:region :project :firewallPolicy}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn removeAssociation$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionNetworkFirewallPolicies/removeAssociation
  
  Required parameters: firewallPolicy, project, region
  
  Optional parameters: name, requestId
  
  Removes an association for the specified network firewall policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:region :project :firewallPolicy})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/firewallPolicies/{firewallPolicy}/removeAssociation"
     #{:region :project :firewallPolicy}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getIamPolicy$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionNetworkFirewallPolicies/getIamPolicy
  
  Required parameters: project, region, resource
  
  Optional parameters: optionsRequestedPolicyVersion
  
  Gets the access control policy for a resource. May be empty if no such policy or resource exists."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project :resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/firewallPolicies/{resource}/getIamPolicy"
     #{:region :project :resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patchRule$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionNetworkFirewallPolicies/patchRule
  
  Required parameters: firewallPolicy, project, region
  
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
  {:pre [(util/has-keys?
          parameters
          #{:region :project :firewallPolicy})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/firewallPolicies/{firewallPolicy}/patchRule"
     #{:region :project :firewallPolicy}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/regionNetworkFirewallPolicies/addRule
  
  Required parameters: firewallPolicy, project, region
  
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
  
  Inserts a rule into a network firewall policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:region :project :firewallPolicy})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/firewallPolicies/{firewallPolicy}/addRule"
     #{:region :project :firewallPolicy}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/regionNetworkFirewallPolicies/list
  
  Required parameters: project, region
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Lists all the network firewall policies that have been configured for the specified project in the given region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/firewallPolicies"
     #{:region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getRule$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionNetworkFirewallPolicies/getRule
  
  Required parameters: firewallPolicy, project, region
  
  Optional parameters: priority
  
  Gets a rule of the specified priority."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:region :project :firewallPolicy})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/firewallPolicies/{firewallPolicy}/getRule"
     #{:region :project :firewallPolicy}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn addAssociation$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionNetworkFirewallPolicies/addAssociation
  
  Required parameters: firewallPolicy, project, region
  
  Optional parameters: replaceExistingAssociation, requestId
  
  Body: 
  
  {:name string,
   :attachmentTarget string,
   :firewallPolicyId string,
   :shortName string,
   :displayName string}
  
  Inserts an association for the specified network firewall policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:region :project :firewallPolicy})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/firewallPolicies/{firewallPolicy}/addAssociation"
     #{:region :project :firewallPolicy}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/regionNetworkFirewallPolicies/getAssociation
  
  Required parameters: firewallPolicy, project, region
  
  Optional parameters: name
  
  Gets an association with the specified name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:region :project :firewallPolicy})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/firewallPolicies/{firewallPolicy}/getAssociation"
     #{:region :project :firewallPolicy}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
