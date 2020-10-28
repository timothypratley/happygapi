(ns happygapi.iamcredentials.projects
  "IAM Service Account Credentials API: projects.
   Creates short-lived credentials for impersonating IAM service accounts. *Note:* This API is tied to the IAM API (iam.googleapis.com). Enabling or disabling this API will also enable or disable the IAM API. 
  See: https://cloud.google.com/iam/docs/creating-short-lived-service-account-credentialsapi/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn serviceAccounts-signJwt$
  "https://cloud.google.com/iam/docs/creating-short-lived-service-account-credentialsapi/reference/rest/v1/projects/serviceAccounts/signJwt
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:delegates [string], :payload string}
  
  Signs a JWT using a service account's system-managed private key."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iamcredentials.googleapis.com/"
     "v1/{+name}:signJwt"
     #{:name}
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

(defn serviceAccounts-generateAccessToken$
  "https://cloud.google.com/iam/docs/creating-short-lived-service-account-credentialsapi/reference/rest/v1/projects/serviceAccounts/generateAccessToken
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:lifetime string, :delegates [string], :scope [string]}
  
  Generates an OAuth 2.0 access token for a service account."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iamcredentials.googleapis.com/"
     "v1/{+name}:generateAccessToken"
     #{:name}
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

(defn serviceAccounts-generateIdToken$
  "https://cloud.google.com/iam/docs/creating-short-lived-service-account-credentialsapi/reference/rest/v1/projects/serviceAccounts/generateIdToken
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:includeEmail boolean, :audience string, :delegates [string]}
  
  Generates an OpenID Connect ID token for a service account."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iamcredentials.googleapis.com/"
     "v1/{+name}:generateIdToken"
     #{:name}
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

(defn serviceAccounts-signBlob$
  "https://cloud.google.com/iam/docs/creating-short-lived-service-account-credentialsapi/reference/rest/v1/projects/serviceAccounts/signBlob
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:payload string, :delegates [string]}
  
  Signs a blob using a service account's system-managed private key."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iamcredentials.googleapis.com/"
     "v1/{+name}:signBlob"
     #{:name}
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
