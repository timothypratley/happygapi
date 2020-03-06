(ns happygapi.iam.iamPolicies
  "Identity and Access Management (IAM) API: iamPolicies.
  Manages identity and access control for Google Cloud Platform resources, including the creation of service accounts, which you can use to authenticate to Google and make API calls.
  See: https://cloud.google.com/iam/api/reference/rest/v1/iamPolicies"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn lintPolicy$
  "https://cloud.google.com/iam/api/reference/rest/v1/iamPolicies/lintPolicy
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:condition {:description string,
               :expression string,
               :title string,
               :location string},
   :fullResourceName string}
  
  Lints a Cloud IAM policy object or its sub fields. Currently supports
  google.iam.v1.Binding.condition.
  
  Each lint operation consists of multiple lint validation units.
  Each unit inspects the input object in regard to a particular linting
  aspect and issues a google.iam.admin.v1.LintResult disclosing the
  result.
  
  The set of applicable validation units is determined by the Cloud IAM
  server and is not configurable.
  
  Regardless of any lint issues or their severities, successful calls to
  `lintPolicy` return an HTTP 200 OK status code."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/iamPolicies:lintPolicy"
     #{}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn queryAuditableServices$
  "https://cloud.google.com/iam/api/reference/rest/v1/iamPolicies/queryAuditableServices
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:fullResourceName string}
  
  Returns a list of services that support service level audit logging
  configuration for the given resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/iamPolicies:queryAuditableServices"
     #{}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
