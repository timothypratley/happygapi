(ns happygapi.compute.securityPolicies
  "Compute Engine API: securityPolicies.
  Creates and runs virtual machines on Google Cloud Platform.
  See: https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/securityPolicies"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn removeRule$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/securityPolicies/removeRule
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/securityPolicies/{securityPolicy}/removeRule"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/securityPolicies/get
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/securityPolicies/{securityPolicy}"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/securityPolicies/insert
  
  Required parameters: project
  
  Optional parameters: requestId
  
  Body: 
  
  {:creationTimestamp string,
   :description string,
   :fingerprint string,
   :id string,
   :kind string,
   :name string,
   :rules [{:action string,
            :description string,
            :kind string,
            :match SecurityPolicyRuleMatcher,
            :preview boolean,
            :priority integer}],
   :selfLink string}
  
  Creates a new policy in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/securityPolicies"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/securityPolicies/patch
  
  Required parameters: project, securityPolicy
  
  Optional parameters: requestId
  
  Body: 
  
  {:creationTimestamp string,
   :description string,
   :fingerprint string,
   :id string,
   :kind string,
   :name string,
   :rules [{:action string,
            :description string,
            :kind string,
            :match SecurityPolicyRuleMatcher,
            :preview boolean,
            :priority integer}],
   :selfLink string}
  
  Patches the specified policy with the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :securityPolicy})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/securityPolicies/{securityPolicy}"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/securityPolicies/delete
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/securityPolicies/{securityPolicy}"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/securityPolicies/patchRule
  
  Required parameters: project, securityPolicy
  
  Optional parameters: priority
  
  Body: 
  
  {:action string,
   :description string,
   :kind string,
   :match {:config SecurityPolicyRuleMatcherConfig,
           :expr Expr,
           :versionedExpr string},
   :preview boolean,
   :priority integer}
  
  Patches a rule at the specified priority."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :securityPolicy})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/securityPolicies/{securityPolicy}/patchRule"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/securityPolicies/addRule
  
  Required parameters: project, securityPolicy
  
  Optional parameters: none
  
  Body: 
  
  {:action string,
   :description string,
   :kind string,
   :match {:config SecurityPolicyRuleMatcherConfig,
           :expr Expr,
           :versionedExpr string},
   :preview boolean,
   :priority integer}
  
  Inserts a rule into a security policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :securityPolicy})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/securityPolicies/{securityPolicy}/addRule"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/securityPolicies/list
  
  Required parameters: project
  
  Optional parameters: filter, maxResults, orderBy, pageToken
  
  List all the policies that have been configured for the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/securityPolicies"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/securityPolicies/getRule
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/securityPolicies/{securityPolicy}/getRule"
     #{:project :securityPolicy}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
