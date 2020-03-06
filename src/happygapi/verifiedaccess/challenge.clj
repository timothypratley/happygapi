(ns happygapi.verifiedaccess.challenge
  "Verified Access API: challenge.
  API for Verified Access chrome extension to provide credential verification for chrome devices connecting to an enterprise network
  See: https://www.google.com/work/chrome/api/reference/rest/v1/challenge"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn verify$
  "https://www.google.com/work/chrome/api/reference/rest/v1/challenge/verify
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:challengeResponse {:signature string, :data string},
   :expectedIdentity string}
  
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
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn create$
  "https://www.google.com/work/chrome/api/reference/rest/v1/challenge/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {}
  
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
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
