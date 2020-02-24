(ns happygapi.siteVerification.webResource
  "Google Site Verification API
  Verifies ownership of websites or domains with Google.
  See: https://developers.google.com/site-verification/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn delete$
  "Required parameters: id
  
  Relinquish ownership of a website or domain."
  {:scopes ["https://www.googleapis.com/auth/siteverification"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/siteVerification/v1/"
     "webResource/{id}"
     #{"id"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "Required parameters: id
  
  Get the most current data for a website or domain."
  {:scopes ["https://www.googleapis.com/auth/siteverification"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/siteVerification/v1/"
     "webResource/{id}"
     #{"id"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn getToken$
  "Required parameters: none
  
  Get a verification token for placing on a website or domain."
  {:scopes ["https://www.googleapis.com/auth/siteverification"
            "https://www.googleapis.com/auth/siteverification.verify_only"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/siteVerification/v1/"
     "token"
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

(defn insert$
  "Required parameters: verificationMethod
  
  Attempt verification of a website or domain."
  {:scopes ["https://www.googleapis.com/auth/siteverification"
            "https://www.googleapis.com/auth/siteverification.verify_only"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"verificationMethod"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/siteVerification/v1/"
     "webResource"
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

(defn list$
  "Required parameters: none
  
  Get the list of your verified websites and domains."
  {:scopes ["https://www.googleapis.com/auth/siteverification"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/siteVerification/v1/"
     "webResource"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "Required parameters: id
  
  Modify the list of owners for your website or domain. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/siteverification"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/siteVerification/v1/"
     "webResource/{id}"
     #{"id"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "Required parameters: id
  
  Modify the list of owners for your website or domain."
  {:scopes ["https://www.googleapis.com/auth/siteverification"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/siteVerification/v1/"
     "webResource/{id}"
     #{"id"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
