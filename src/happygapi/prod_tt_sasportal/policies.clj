(ns happygapi.prod_tt_sasportal.policies
  "SAS Portal API (Testing): policies.
  
  See: https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/policies"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn test$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/policies/test
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:resource string, :permissions [string]}
  
  Returns permissions that a caller has on the specified resource."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/policies:test"
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

(defn set$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/policies/set
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:etag string, :assignments [SasPortalAssignment]},
   :resource string}
  
  Sets the access control policy on the specified resource. Replaces any
  existing policy."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/policies:set"
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

(defn get$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/policies/get
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:resource string}
  
  Gets the access control policy for a resource.
  Returns an empty policy if the resource exists and does not have a policy
  set."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/policies:get"
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
