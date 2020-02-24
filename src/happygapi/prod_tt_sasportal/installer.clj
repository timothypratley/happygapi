(ns happygapi.prod_tt_sasportal.installer
  "SAS Portal API (Testing)
  
  See: https://developers.google.com/spectrum-access-system/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn generateSecret$
  "Required parameters: none
  
  Generates a secret to be used with the ValidateInstaller method"
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
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
      :body body}
     auth))))

(defn validate$
  "Required parameters: none
  
  Validates the identity of a Certified Professional Installer (CPI)."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
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
      :body body}
     auth))))
