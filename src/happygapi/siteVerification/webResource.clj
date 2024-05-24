(ns happygapi.siteVerification.webResource
  "Google Site Verification API: webResource.
  Verifies ownership of websites or domains with Google.
  See: https://developers.google.com/site-verification/docs/reference/rest/v1/webResource"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/site-verification/api/reference/rest/v1/webResource/delete
  
  Required parameters: id
  
  Optional parameters: none
  
  Relinquish ownership of a website or domain."
  {:scopes ["https://www.googleapis.com/auth/siteverification"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/siteVerification/v1/"
     "webResource/{id}"
     #{:id}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/site-verification/api/reference/rest/v1/webResource/get
  
  Required parameters: id
  
  Optional parameters: none
  
  Get the most current data for a website or domain."
  {:scopes ["https://www.googleapis.com/auth/siteverification"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/siteVerification/v1/"
     "webResource/{id}"
     #{:id}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getToken$
  "https://developers.google.com/site-verification/api/reference/rest/v1/webResource/getToken
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:site {:identifier string, :type string}, :verificationMethod string}
  
  Get a verification token for placing on a website or domain."
  {:scopes ["https://www.googleapis.com/auth/siteverification"
            "https://www.googleapis.com/auth/siteverification.verify_only"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/siteVerification/v1/"
     "token"
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

(defn insert$
  "https://developers.google.com/site-verification/api/reference/rest/v1/webResource/insert
  
  Required parameters: verificationMethod
  
  Optional parameters: none
  
  Body: 
  
  {:id string,
   :owners [string],
   :site {:identifier string, :type string}}
  
  Attempt verification of a website or domain."
  {:scopes ["https://www.googleapis.com/auth/siteverification"
            "https://www.googleapis.com/auth/siteverification.verify_only"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:verificationMethod})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/siteVerification/v1/"
     "webResource"
     #{:verificationMethod}
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

(defn list$
  "https://developers.google.com/site-verification/api/reference/rest/v1/webResource/list
  
  Required parameters: none
  
  Optional parameters: none
  
  Get the list of your verified websites and domains."
  {:scopes ["https://www.googleapis.com/auth/siteverification"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/siteVerification/v1/"
     "webResource"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/site-verification/api/reference/rest/v1/webResource/patch
  
  Required parameters: id
  
  Optional parameters: none
  
  Body: 
  
  {:id string,
   :owners [string],
   :site {:identifier string, :type string}}
  
  Modify the list of owners for your website or domain. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/siteverification"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/siteVerification/v1/"
     "webResource/{id}"
     #{:id}
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

(defn update$
  "https://developers.google.com/site-verification/api/reference/rest/v1/webResource/update
  
  Required parameters: id
  
  Optional parameters: none
  
  Body: 
  
  {:id string,
   :owners [string],
   :site {:identifier string, :type string}}
  
  Modify the list of owners for your website or domain."
  {:scopes ["https://www.googleapis.com/auth/siteverification"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/siteVerification/v1/"
     "webResource/{id}"
     #{:id}
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
