(ns happygapi.compute.securityPolicies
  "Compute Engine API: securityPolicies.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/securityPolicies"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn removeRule$
  "https://cloud.google.com/compute/api/reference/rest/v1/securityPolicies/removeRule
  
  Required parameters: project, securityPolicy
  
  Optional parameters: priority
  
  Deletes a rule at the specified priority."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project :securityPolicy})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/securityPolicies/{securityPolicy}/removeRule"
     #{:project :securityPolicy}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/securityPolicies/get
  
  Required parameters: project, securityPolicy
  
  Optional parameters: none
  
  List all of the ordered rules present in a single specified policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project :securityPolicy})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/securityPolicies/{securityPolicy}"
     #{:project :securityPolicy}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/securityPolicies/insert
  
  Required parameters: project
  
  Optional parameters: requestId, validateOnly
  
  Body: 
  
  {:description string,
   :labels {},
   :userDefinedFields [{:name string,
                        :base string,
                        :offset integer,
                        :size integer,
                        :mask string}],
   :creationTimestamp string,
   :name string,
   :selfLink string,
   :type string,
   :rules [{:description string,
            :headerAction SecurityPolicyRuleHttpHeaderAction,
            :networkMatch SecurityPolicyRuleNetworkMatcher,
            :redirectOptions SecurityPolicyRuleRedirectOptions,
            :preconfiguredWafConfig SecurityPolicyRulePreconfiguredWafConfig,
            :preview boolean,
            :rateLimitOptions SecurityPolicyRuleRateLimitOptions,
            :priority integer,
            :kind string,
            :action string,
            :match SecurityPolicyRuleMatcher}],
   :region string,
   :recaptchaOptionsConfig {:redirectSiteKey string},
   :id string,
   :adaptiveProtectionConfig {:layer7DdosDefenseConfig SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfig},
   :kind string,
   :ddosProtectionConfig {:ddosProtection string},
   :advancedOptionsConfig {:jsonParsing string,
                           :jsonCustomConfig SecurityPolicyAdvancedOptionsConfigJsonCustomConfig,
                           :logLevel string,
                           :userIpRequestHeaders [string]},
   :fingerprint string,
   :labelFingerprint string}
  
  Creates a new policy in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/securityPolicies"
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

(defn listPreconfiguredExpressionSets$
  "https://cloud.google.com/compute/api/reference/rest/v1/securityPolicies/listPreconfiguredExpressionSets
  
  Required parameters: project
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Gets the current list of preconfigured Web Application Firewall (WAF) expressions."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/securityPolicies/listPreconfiguredExpressionSets"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://cloud.google.com/compute/api/reference/rest/v1/securityPolicies/patch
  
  Required parameters: project, securityPolicy
  
  Optional parameters: requestId, updateMask
  
  Body: 
  
  {:description string,
   :labels {},
   :userDefinedFields [{:name string,
                        :base string,
                        :offset integer,
                        :size integer,
                        :mask string}],
   :creationTimestamp string,
   :name string,
   :selfLink string,
   :type string,
   :rules [{:description string,
            :headerAction SecurityPolicyRuleHttpHeaderAction,
            :networkMatch SecurityPolicyRuleNetworkMatcher,
            :redirectOptions SecurityPolicyRuleRedirectOptions,
            :preconfiguredWafConfig SecurityPolicyRulePreconfiguredWafConfig,
            :preview boolean,
            :rateLimitOptions SecurityPolicyRuleRateLimitOptions,
            :priority integer,
            :kind string,
            :action string,
            :match SecurityPolicyRuleMatcher}],
   :region string,
   :recaptchaOptionsConfig {:redirectSiteKey string},
   :id string,
   :adaptiveProtectionConfig {:layer7DdosDefenseConfig SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfig},
   :kind string,
   :ddosProtectionConfig {:ddosProtection string},
   :advancedOptionsConfig {:jsonParsing string,
                           :jsonCustomConfig SecurityPolicyAdvancedOptionsConfigJsonCustomConfig,
                           :logLevel string,
                           :userIpRequestHeaders [string]},
   :fingerprint string,
   :labelFingerprint string}
  
  Patches the specified policy with the data included in the request. To clear fields in the policy, leave the fields empty and specify them in the updateMask. This cannot be used to be update the rules in the policy. Please use the per rule methods like addRule, patchRule, and removeRule instead."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :securityPolicy})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/securityPolicies/{securityPolicy}"
     #{:project :securityPolicy}
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

(defn setLabels$
  "https://cloud.google.com/compute/api/reference/rest/v1/securityPolicies/setLabels
  
  Required parameters: project, resource
  
  Optional parameters: none
  
  Body: 
  
  {:labels {}, :labelFingerprint string}
  
  Sets the labels on a security policy. To learn more about labels, read the Labeling Resources documentation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/securityPolicies/{resource}/setLabels"
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

(defn aggregatedList$
  "https://cloud.google.com/compute/api/reference/rest/v1/securityPolicies/aggregatedList
  
  Required parameters: project
  
  Optional parameters: filter, includeAllScopes, maxResults, orderBy, pageToken, returnPartialSuccess, serviceProjectNumber
  
  Retrieves the list of all SecurityPolicy resources, regional and global, available to the specified project. To prevent failure, Google recommends that you set the `returnPartialSuccess` parameter to `true`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/aggregated/securityPolicies"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://cloud.google.com/compute/api/reference/rest/v1/securityPolicies/delete
  
  Required parameters: project, securityPolicy
  
  Optional parameters: requestId
  
  Deletes the specified policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project :securityPolicy})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/securityPolicies/{securityPolicy}"
     #{:project :securityPolicy}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patchRule$
  "https://cloud.google.com/compute/api/reference/rest/v1/securityPolicies/patchRule
  
  Required parameters: project, securityPolicy
  
  Optional parameters: priority, updateMask, validateOnly
  
  Body: 
  
  {:description string,
   :headerAction {:requestHeadersToAdds [SecurityPolicyRuleHttpHeaderActionHttpHeaderOption]},
   :networkMatch {:userDefinedFields [SecurityPolicyRuleNetworkMatcherUserDefinedFieldMatch],
                  :srcIpRanges [string],
                  :destIpRanges [string],
                  :ipProtocols [string],
                  :srcPorts [string],
                  :destPorts [string],
                  :srcRegionCodes [string],
                  :srcAsns [integer]},
   :redirectOptions {:type string, :target string},
   :preconfiguredWafConfig {:exclusions [SecurityPolicyRulePreconfiguredWafConfigExclusion]},
   :preview boolean,
   :rateLimitOptions {:enforceOnKeyConfigs [SecurityPolicyRuleRateLimitOptionsEnforceOnKeyConfig],
                      :enforceOnKey string,
                      :exceedAction string,
                      :banDurationSec integer,
                      :enforceOnKeyName string,
                      :rateLimitThreshold SecurityPolicyRuleRateLimitOptionsThreshold,
                      :banThreshold SecurityPolicyRuleRateLimitOptionsThreshold,
                      :conformAction string,
                      :exceedRedirectOptions SecurityPolicyRuleRedirectOptions},
   :priority integer,
   :kind string,
   :action string,
   :match {:expr Expr,
           :exprOptions SecurityPolicyRuleMatcherExprOptions,
           :versionedExpr string,
           :config SecurityPolicyRuleMatcherConfig}}
  
  Patches a rule at the specified priority. To clear fields in the rule, leave the fields empty and specify them in the updateMask."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :securityPolicy})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/securityPolicies/{securityPolicy}/patchRule"
     #{:project :securityPolicy}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/securityPolicies/addRule
  
  Required parameters: project, securityPolicy
  
  Optional parameters: validateOnly
  
  Body: 
  
  {:description string,
   :headerAction {:requestHeadersToAdds [SecurityPolicyRuleHttpHeaderActionHttpHeaderOption]},
   :networkMatch {:userDefinedFields [SecurityPolicyRuleNetworkMatcherUserDefinedFieldMatch],
                  :srcIpRanges [string],
                  :destIpRanges [string],
                  :ipProtocols [string],
                  :srcPorts [string],
                  :destPorts [string],
                  :srcRegionCodes [string],
                  :srcAsns [integer]},
   :redirectOptions {:type string, :target string},
   :preconfiguredWafConfig {:exclusions [SecurityPolicyRulePreconfiguredWafConfigExclusion]},
   :preview boolean,
   :rateLimitOptions {:enforceOnKeyConfigs [SecurityPolicyRuleRateLimitOptionsEnforceOnKeyConfig],
                      :enforceOnKey string,
                      :exceedAction string,
                      :banDurationSec integer,
                      :enforceOnKeyName string,
                      :rateLimitThreshold SecurityPolicyRuleRateLimitOptionsThreshold,
                      :banThreshold SecurityPolicyRuleRateLimitOptionsThreshold,
                      :conformAction string,
                      :exceedRedirectOptions SecurityPolicyRuleRedirectOptions},
   :priority integer,
   :kind string,
   :action string,
   :match {:expr Expr,
           :exprOptions SecurityPolicyRuleMatcherExprOptions,
           :versionedExpr string,
           :config SecurityPolicyRuleMatcherConfig}}
  
  Inserts a rule into a security policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :securityPolicy})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/securityPolicies/{securityPolicy}/addRule"
     #{:project :securityPolicy}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/securityPolicies/list
  
  Required parameters: project
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  List all the policies that have been configured for the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/securityPolicies"
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
  "https://cloud.google.com/compute/api/reference/rest/v1/securityPolicies/getRule
  
  Required parameters: project, securityPolicy
  
  Optional parameters: priority
  
  Gets a rule at the specified priority."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project :securityPolicy})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/securityPolicies/{securityPolicy}/getRule"
     #{:project :securityPolicy}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
