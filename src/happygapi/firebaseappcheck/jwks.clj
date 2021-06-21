(ns happygapi.firebaseappcheck.jwks
  "Firebase App Check API: jwks.
  App Check works alongside other Firebase services to help protect your backend resources from abuse, such as billing fraud or phishing. With App Check, devices running your app will use an app or device attestation provider that attests to one or both of the following: * Requests originate from your authentic app * Requests originate from an authentic, untampered device This attestation is attached to every request your app makes to your Firebase backend resources. The Firebase App Check REST API allows you to manage your App Check configurations programmatically. It also allows you to exchange attestation material for App Check tokens directly without using a Firebase SDK. Finally, it allows you to obtain the public key set necessary to validate an App Check token yourself. [Learn more about App Check](https://firebase.google.com/docs/app-check).
  See: https://firebase.google.com/docs/app-checkapi/reference/rest/v1beta/jwks"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://firebase.google.com/docs/app-checkapi/reference/rest/v1beta/jwks/get
  
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
     "v1beta/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
