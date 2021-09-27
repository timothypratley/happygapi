(ns happygapi.prod_tt_sasportal.installer
  "SAS Portal API (Testing): installer.
  
  See: https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/installer"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn validate$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/installer/validate
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:installerId string, :secret string, :encodedSecret string}
  
  Validates the identity of a Certified Professional Installer (CPI)."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/installer:validate"
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

(defn generateSecret$
  "https://developers.google.com/spectrum-access-system/api/reference/rest/v1alpha1/installer/generateSecret
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Generates a secret to be used with the ValidateInstaller."
  {:scopes ["https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://prod-tt-sasportal.googleapis.com/"
     "v1alpha1/installer:generateSecret"
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
