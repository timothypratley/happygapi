(ns happygapi.prod_tt_sasportal.installer
  "SAS Portal API (Testing): installer.
  
  See: https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/installer"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn generateSecret$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/installer/generateSecret
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {}
  
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
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn validate$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/installer/validate
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:installerId string, :secret string, :encodedSecret string}
  
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
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
