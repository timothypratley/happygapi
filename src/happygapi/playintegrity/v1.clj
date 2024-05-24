(ns happygapi.playintegrity.v1
  "Google Play Integrity API: v1.
  The Play Integrity API helps you check that you're interacting with your genuine app on a genuine Android device powered by Google Play services. The Play Integrity API has replaced SafetyNet Attestation and Android Device Verification.
  See: https://developer.android.com/google/play/integritydocs/reference/rest/v1/v1"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn $
  "https://developer.android.com/google/play/integrityapi/reference/rest/v1/decodeIntegrityToken
  
  Required parameters: packageName
  
  Optional parameters: none
  
  Body: 
  
  {:integrityToken string}
  
  Decodes the integrity token and returns the token payload."
  {:scopes ["https://www.googleapis.com/auth/playintegrity"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:packageName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://playintegrity.googleapis.com/"
     "v1/{+packageName}:decodeIntegrityToken"
     #{:packageName}
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
