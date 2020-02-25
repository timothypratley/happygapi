(ns happygapi.verifiedaccess.challenge
  "Verified Access API
  API for Verified Access chrome extension to provide credential verification for chrome devices connecting to an enterprise network
  See: https://www.google.com/work/chrome/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "verifiedaccess_schema.edn"))))

(defn verify$
  "Required parameters: none
  
  Optional parameters: none
  
  VerifyChallengeResponse API"
  {:scopes ["https://www.googleapis.com/auth/verifiedaccess"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://verifiedaccess.googleapis.com/"
     "v1/challenge:verify"
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

(defn create$
  "Required parameters: none
  
  Optional parameters: none
  
  CreateChallenge API"
  {:scopes ["https://www.googleapis.com/auth/verifiedaccess"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://verifiedaccess.googleapis.com/"
     "v1/challenge"
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
