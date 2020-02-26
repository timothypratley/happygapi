(ns happygapi.siteVerification.webResource
  "Google Site Verification API
  Verifies ownership of websites or domains with Google.
  See: https://developers.google.com/site-verification/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "siteVerification_schema.edn"))))

(defn delete$
  "Required parameters: id
  
  Optional parameters: none
  
  Relinquish ownership of a website or domain."
  {:scopes ["https://www.googleapis.com/auth/siteverification"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id"})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: none
  
  Get the most current data for a website or domain."
  {:scopes ["https://www.googleapis.com/auth/siteverification"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id"})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: none
  
  Get a verification token for placing on a website or domain."
  {:scopes ["https://www.googleapis.com/auth/siteverification"
            "https://www.googleapis.com/auth/siteverification.verify_only"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
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
      :body (json/generate-string body)}
     auth))))

(defn insert$
  "Required parameters: verificationMethod
  
  Optional parameters: none
  
  Attempt verification of a website or domain."
  {:scopes ["https://www.googleapis.com/auth/siteverification"
            "https://www.googleapis.com/auth/siteverification.verify_only"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"verificationMethod"})
         (json-schema/validate schemas args)]}
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
      :body (json/generate-string body)}
     auth))))

(defn list$
  "Required parameters: none
  
  Optional parameters: none
  
  Get the list of your verified websites and domains."
  {:scopes ["https://www.googleapis.com/auth/siteverification"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: none
  
  Modify the list of owners for your website or domain. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/siteverification"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id"})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: none
  
  Modify the list of owners for your website or domain."
  {:scopes ["https://www.googleapis.com/auth/siteverification"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"id"})
         (json-schema/validate schemas args)]}
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
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))
