(ns happygapi.verifiedaccess.challenge
  "Chrome Verified Access API: challenge.
  API for Verified Access chrome extension to provide credential verification for chrome devices connecting to an enterprise network
  See: https://developers.google.com/chrome/verified-accessapi/reference/rest/v1/challenge"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn verify$
  "https://developers.google.com/chrome/verified-accessapi/reference/rest/v1/challenge/verify
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:challengeResponse {:data string, :signature string},
   :expectedIdentity string}
  
  VerifyChallengeResponse API"
  {:scopes ["https://www.googleapis.com/auth/verifiedaccess"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://verifiedaccess.googleapis.com/"
     "v1/challenge:verify"
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

(defn create$
  "https://developers.google.com/chrome/verified-accessapi/reference/rest/v1/challenge/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  CreateChallenge API"
  {:scopes ["https://www.googleapis.com/auth/verifiedaccess"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://verifiedaccess.googleapis.com/"
     "v1/challenge"
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
