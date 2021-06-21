(ns happygapi.sts.v1
  "Security Token Service API: v1.
  The Security Token Service exchanges Google or third-party credentials for a short-lived access token to Google Cloud resources.
  See: http://cloud.google.com/iam/docs/workload-identity-federationapi/reference/rest/v1/v1"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn $
  "http://cloud.google.com/iam/docs/workload-identity-federationapi/reference/rest/v1/token
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:grantType string,
   :subjectToken string,
   :options string,
   :subjectTokenType string,
   :scope string,
   :requestedTokenType string,
   :audience string}
  
  Exchanges a credential for a Google OAuth 2.0 access token. The token asserts an external identity within a workload identity pool, or it applies a Credential Access Boundary to a Google access token. When you call this method, do not send the `Authorization` HTTP header in the request. This method does not require the `Authorization` header, and using the header can cause the request to fail."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sts.googleapis.com/"
     "v1/token"
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

(defn $
  "http://cloud.google.com/iam/docs/workload-identity-federationapi/reference/rest/v1/introspect
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:tokenTypeHint string, :token string}
  
  Gets information about a Google OAuth 2.0 access token issued by the Google Cloud [Security Token Service API](https://cloud.google.com/iam/docs/reference/sts/rest)."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sts.googleapis.com/"
     "v1/introspect"
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
