(ns happygapi.sasportal.installer
  "SAS Portal API
  
  See: https://developers.google.com/spectrum-access-system/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "sasportal_schema.edn"))))

(defn validate$
  "Required parameters: none
  
  Optional parameters: none
  
  Validates the identity of a Certified Professional Installer (CPI)."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/installer:validate"
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

(defn generateSecret$
  "Required parameters: none
  
  Optional parameters: none
  
  Generates a secret to be used with the ValidateInstaller method"
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sasportal.googleapis.com/"
     "v1alpha1/installer:generateSecret"
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
