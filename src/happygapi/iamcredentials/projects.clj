(ns happygapi.iamcredentials.projects
  "IAM Service Account Credentials API
  Creates short-lived, limited-privilege credentials for IAM service accounts.
  See: https://cloud.google.com/iam/docs/creating-short-lived-service-account-credentials"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn serviceAccounts-generateAccessToken$
  "Required parameters: name
  
  Generates an OAuth 2.0 access token for a service account."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iamcredentials.googleapis.com/"
     "v1/{+name}:generateAccessToken"
     #{"name"}
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

(defn serviceAccounts-generateIdToken$
  "Required parameters: name
  
  Generates an OpenID Connect ID token for a service account."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iamcredentials.googleapis.com/"
     "v1/{+name}:generateIdToken"
     #{"name"}
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

(defn serviceAccounts-signBlob$
  "Required parameters: name
  
  Signs a blob using a service account's system-managed private key."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iamcredentials.googleapis.com/"
     "v1/{+name}:signBlob"
     #{"name"}
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

(defn serviceAccounts-signJwt$
  "Required parameters: name
  
  Signs a JWT using a service account's system-managed private key."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iamcredentials.googleapis.com/"
     "v1/{+name}:signJwt"
     #{"name"}
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
