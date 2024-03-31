(ns happygapi.compute.regionSecurityPolicies
  "Compute Engine API: regionSecurityPolicies.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/regionSecurityPolicies"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn removeRule$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionSecurityPolicies/removeRule
  
  Required parameters: project, region, securityPolicy
  
  Optional parameters: priority
  
  Deletes a rule at the specified priority."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:region :project :securityPolicy})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/securityPolicies/{securityPolicy}/removeRule"
     #{:region :project :securityPolicy}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionSecurityPolicies/get
  
  Required parameters: project, region, securityPolicy
  
  Optional parameters: none
  
  List all of the ordered rules present in a single specified policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:region :project :securityPolicy})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/securityPolicies/{securityPolicy}"
     #{:region :project :securityPolicy}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionSecurityPolicies/insert
  
  Required parameters: project, region
  
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
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/securityPolicies"
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

(defn patch$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionSecurityPolicies/patch
  
  Required parameters: project, region, securityPolicy
  
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
  {:pre [(util/has-keys?
          parameters
          #{:region :project :securityPolicy})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/securityPolicies/{securityPolicy}"
     #{:region :project :securityPolicy}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/regionSecurityPolicies/delete
  
  Required parameters: project, region, securityPolicy
  
  Optional parameters: requestId
  
  Deletes the specified policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:region :project :securityPolicy})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/securityPolicies/{securityPolicy}"
     #{:region :project :securityPolicy}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patchRule$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionSecurityPolicies/patchRule
  
  Required parameters: project, region, securityPolicy
  
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
  {:pre [(util/has-keys?
          parameters
          #{:region :project :securityPolicy})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/securityPolicies/{securityPolicy}/patchRule"
     #{:region :project :securityPolicy}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/regionSecurityPolicies/addRule
  
  Required parameters: project, region, securityPolicy
  
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
  {:pre [(util/has-keys?
          parameters
          #{:region :project :securityPolicy})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/securityPolicies/{securityPolicy}/addRule"
     #{:region :project :securityPolicy}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/regionSecurityPolicies/list
  
  Required parameters: project, region
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  List all the policies that have been configured for the specified project and region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/securityPolicies"
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
  "https://cloud.google.com/compute/api/reference/rest/v1/regionSecurityPolicies/getRule
  
  Required parameters: project, region, securityPolicy
  
  Optional parameters: priority
  
  Gets a rule at the specified priority."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:region :project :securityPolicy})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/securityPolicies/{securityPolicy}/getRule"
     #{:region :project :securityPolicy}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
