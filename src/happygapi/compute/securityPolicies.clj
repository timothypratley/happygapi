(ns happygapi.compute.securityPolicies
  "Compute Engine API: securityPolicies.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/securityPolicies"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn removeRule$
  "https://cloud.google.com/compute/api/reference/rest/v1/securityPolicies/removeRule
  
  Required parameters: securityPolicy, project
  
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
  
  Required parameters: securityPolicy, project
  
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
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :creationTimestamp string,
   :name string,
   :selfLink string,
   :rules [{:preview boolean,
            :action string,
            :match SecurityPolicyRuleMatcher,
            :kind string,
            :priority integer,
            :description string}],
   :id string,
   :adaptiveProtectionConfig {:layer7DdosDefenseConfig SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfig},
   :kind string,
   :advancedOptionsConfig {:jsonParsing string, :logLevel string},
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
  
  Optional parameters: maxResults, orderBy, pageToken, filter, returnPartialSuccess
  
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
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :creationTimestamp string,
   :name string,
   :selfLink string,
   :rules [{:preview boolean,
            :action string,
            :match SecurityPolicyRuleMatcher,
            :kind string,
            :priority integer,
            :description string}],
   :id string,
   :adaptiveProtectionConfig {:layer7DdosDefenseConfig SecurityPolicyAdaptiveProtectionConfigLayer7DdosDefenseConfig},
   :kind string,
   :advancedOptionsConfig {:jsonParsing string, :logLevel string},
   :fingerprint string}
  
  Patches the specified policy with the data included in the request. This cannot be used to be update the rules in the policy. Please use the per rule methods like addRule, patchRule, and removeRule instead."
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

(defn delete$
  "https://cloud.google.com/compute/api/reference/rest/v1/securityPolicies/delete
  
  Required parameters: securityPolicy, project
  
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
  
  Required parameters: securityPolicy, project
  
  Optional parameters: priority
  
  Body: 
  
  {:preview boolean,
   :action string,
   :match {:versionedExpr string,
           :config SecurityPolicyRuleMatcherConfig,
           :expr Expr},
   :kind string,
   :priority integer,
   :description string}
  
  Patches a rule at the specified priority."
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
  
  Required parameters: securityPolicy, project
  
  Optional parameters: none
  
  Body: 
  
  {:preview boolean,
   :action string,
   :match {:versionedExpr string,
           :config SecurityPolicyRuleMatcherConfig,
           :expr Expr},
   :kind string,
   :priority integer,
   :description string}
  
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
  
  Optional parameters: returnPartialSuccess, orderBy, pageToken, filter, maxResults
  
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
  
  Required parameters: securityPolicy, project
  
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
