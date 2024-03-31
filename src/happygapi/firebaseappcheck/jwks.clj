(ns happygapi.firebaseappcheck.jwks
  "Firebase App Check API: jwks.
  Firebase App Check works alongside other Firebase services to help protect your backend resources from abuse, such as billing fraud or phishing.
  See: https://firebase.google.com/docs/app-checkapi/reference/rest/v1/jwks"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://firebase.google.com/docs/app-checkapi/reference/rest/v1/jwks/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns a public JWK set as specified by [RFC 7517](https://tools.ietf.org/html/rfc7517) that can be used to verify App Check tokens. Exactly one of the public keys in the returned set will successfully validate any App Check token that is currently valid."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
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
