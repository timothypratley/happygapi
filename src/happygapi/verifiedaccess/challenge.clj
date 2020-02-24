(ns happygapi.verifiedaccess.challenge
  "Verified Access API
  API for Verified Access chrome extension to provide credential verification for chrome devices connecting to an enterprise network
  See: https://www.google.com/work/chrome/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn verify$
  "Required parameters: none
  
  VerifyChallengeResponse API"
  {:scopes ["https://www.googleapis.com/auth/verifiedaccess"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
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
  
  CreateChallenge API"
  {:scopes ["https://www.googleapis.com/auth/verifiedaccess"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
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
