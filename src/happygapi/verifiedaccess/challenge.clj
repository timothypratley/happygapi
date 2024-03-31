(ns happygapi.verifiedaccess.challenge
  "Chrome Verified Access API: challenge.
  API for Verified Access chrome extension to provide credential verification for chrome devices connecting to an enterprise network
  See: https://developers.google.com/chrome/verified-accessapi/reference/rest/v2/challenge"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn generate$
  "https://developers.google.com/chrome/verified-accessapi/reference/rest/v2/challenge/generate
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Generates a new challenge."
  {:scopes ["https://www.googleapis.com/auth/verifiedaccess"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://verifiedaccess.googleapis.com/"
     "v2/challenge:generate"
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

(defn verify$
  "https://developers.google.com/chrome/verified-accessapi/reference/rest/v2/challenge/verify
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:challengeResponse string, :expectedIdentity string}
  
  Verifies the challenge response."
  {:scopes ["https://www.googleapis.com/auth/verifiedaccess"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://verifiedaccess.googleapis.com/"
     "v2/challenge:verify"
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
