(ns happygapi.prod_tt_sasportal.policies
  "SAS Portal API (Testing)
  
  See: https://developers.google.com/spectrum-access-system/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "prod_tt_sasportal_schema.edn"))))

(defn get$
  "Required parameters: none
  
  Optional parameters: none
  
  Gets the access control policy for a resource.
  Returns an empty policy if the resource exists and does not have a policy
  set."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/policies:get"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn test$
  "Required parameters: none
  
  Optional parameters: none
  
  Returns permissions that a caller has on the specified resource."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/policies:test"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn set$
  "Required parameters: none
  
  Optional parameters: none
  
  Sets the access control policy on the specified resource. Replaces any
  existing policy."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/policies:set"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))
