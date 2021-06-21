(ns happygapi.sasportal.policies
  "SAS Portal API: policies.
  
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
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/policies:test"
     #{}
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

(defn set$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/policies/set
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:resource string,
   :disableNotification boolean,
   :policy {:assignments [SasPortalAssignment], :etag string}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/policies:set"
     #{}
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
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/policies/get
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:resource string}
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/policies:get"
     #{}
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
