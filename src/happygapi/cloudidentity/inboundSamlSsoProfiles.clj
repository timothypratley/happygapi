(ns happygapi.cloudidentity.inboundSamlSsoProfiles
  "Cloud Identity API: inboundSamlSsoProfiles.
  API for provisioning and managing identity resources.
  See: https://cloud.google.com/identity/docs/reference/rest/v1/inboundSamlSsoProfiles"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://cloud.google.com/identity/api/reference/rest/v1/inboundSamlSsoProfiles/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :customer string,
   :displayName string,
   :idpConfig {:entityId string,
               :singleSignOnServiceUri string,
               :logoutRedirectUri string,
               :changePasswordUri string},
   :spConfig {:entityId string, :assertionConsumerServiceUri string}}
  
  Creates an InboundSamlSsoProfile for a customer."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/inboundSamlSsoProfiles"
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

(defn patch$
  "https://cloud.google.com/identity/api/reference/rest/v1/inboundSamlSsoProfiles/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :customer string,
   :displayName string,
   :idpConfig {:entityId string,
               :singleSignOnServiceUri string,
               :logoutRedirectUri string,
               :changePasswordUri string},
   :spConfig {:entityId string, :assertionConsumerServiceUri string}}
  
  Updates an InboundSamlSsoProfile."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/{+name}"
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

(defn delete$
  "https://cloud.google.com/identity/api/reference/rest/v1/inboundSamlSsoProfiles/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an InboundSamlSsoProfile."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://cloud.google.com/identity/api/reference/rest/v1/inboundSamlSsoProfiles/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an InboundSamlSsoProfile."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://cloud.google.com/identity/api/reference/rest/v1/inboundSamlSsoProfiles/list
  
  Required parameters: none
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists InboundSamlSsoProfiles for a customer."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/inboundSamlSsoProfiles"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn idpCredentials-delete$
  "https://cloud.google.com/identity/api/reference/rest/v1/inboundSamlSsoProfiles/idpCredentials/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an IdpCredential."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn idpCredentials-get$
  "https://cloud.google.com/identity/api/reference/rest/v1/inboundSamlSsoProfiles/idpCredentials/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an IdpCredential."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn idpCredentials-list$
  "https://cloud.google.com/identity/api/reference/rest/v1/inboundSamlSsoProfiles/idpCredentials/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Returns a list of IdpCredentials in an InboundSamlSsoProfile."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/{+parent}/idpCredentials"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn idpCredentials-add$
  "https://cloud.google.com/identity/api/reference/rest/v1/inboundSamlSsoProfiles/idpCredentials/add
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:pemData string}
  
  Adds an IdpCredential. Up to 2 credentials are allowed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/{+parent}/idpCredentials:add"
     #{:parent}
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
