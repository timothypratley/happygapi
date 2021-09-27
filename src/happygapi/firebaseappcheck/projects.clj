(ns happygapi.firebaseappcheck.projects
  "Firebase App Check API: projects.
  App Check works alongside other Firebase services to help protect your backend resources from abuse, such as billing fraud or phishing. With App Check, devices running your app will use an app or device attestation provider that attests to one or both of the following: * Requests originate from your authentic app * Requests originate from an authentic, untampered device This attestation is attached to every request your app makes to your Firebase backend resources. The Firebase App Check REST API allows you to manage your App Check configurations programmatically. It also allows you to exchange attestation material for App Check tokens directly without using a Firebase SDK. Finally, it allows you to obtain the public key set necessary to validate an App Check token yourself. [Learn more about App Check](https://firebase.google.com/docs/app-check).
  See: https://firebase.google.com/docs/app-checkapi/reference/rest/v1beta/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn apps-exchangeAppAttestAssertion$
  "https://firebase.google.com/docs/app-checkapi/reference/rest/v1beta/projects/apps/exchangeAppAttestAssertion
  
  Required parameters: app
  
  Optional parameters: none
  
  Body: 
  
  {:assertion string, :artifact string, :challenge string}
  
  Accepts a AppAttest Artifact and Assertion, and uses the developer's preconfigured auth token to verify the token with Apple. Returns an AttestationToken with the App ID as specified by the `app` field included as attested claims."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:app})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1beta/{+app}:exchangeAppAttestAssertion"
     #{:app}
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

(defn apps-exchangeRecaptchaToken$
  "https://firebase.google.com/docs/app-checkapi/reference/rest/v1beta/projects/apps/exchangeRecaptchaToken
  
  Required parameters: app
  
  Optional parameters: none
  
  Body: 
  
  {:recaptchaToken string}
  
  Validates a [reCAPTCHA v3 response token](https://developers.google.com/recaptcha/docs/v3). If valid, returns an App Check token encapsulated in an AttestationTokenResponse."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:app})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1beta/{+app}:exchangeRecaptchaToken"
     #{:app}
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

(defn apps-exchangeDeviceCheckToken$
  "https://firebase.google.com/docs/app-checkapi/reference/rest/v1beta/projects/apps/exchangeDeviceCheckToken
  
  Required parameters: app
  
  Optional parameters: none
  
  Body: 
  
  {:deviceToken string}
  
  Accepts a [`device_token`](https://developer.apple.com/documentation/devicecheck/dcdevice) issued by DeviceCheck, and attempts to validate it with Apple. If valid, returns an App Check token encapsulated in an AttestationTokenResponse."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:app})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1beta/{+app}:exchangeDeviceCheckToken"
     #{:app}
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

(defn apps-exchangeAppAttestAttestation$
  "https://firebase.google.com/docs/app-checkapi/reference/rest/v1beta/projects/apps/exchangeAppAttestAttestation
  
  Required parameters: app
  
  Optional parameters: none
  
  Body: 
  
  {:challenge string, :keyId string, :attestationStatement string}
  
  Accepts a AppAttest CBOR Attestation, and uses the developer's preconfigured team and bundle IDs to verify the token with Apple. Returns an Attestation Artifact that can later be exchanged for an AttestationToken in ExchangeAppAttestAssertion."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:app})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1beta/{+app}:exchangeAppAttestAttestation"
     #{:app}
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

(defn apps-exchangeSafetyNetToken$
  "https://firebase.google.com/docs/app-checkapi/reference/rest/v1beta/projects/apps/exchangeSafetyNetToken
  
  Required parameters: app
  
  Optional parameters: none
  
  Body: 
  
  {:safetyNetToken string}
  
  Validates a [SafetyNet token](https://developer.android.com/training/safetynet/attestation#request-attestation-step). If valid, returns an App Check token encapsulated in an AttestationTokenResponse."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:app})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1beta/{+app}:exchangeSafetyNetToken"
     #{:app}
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

(defn apps-generateAppAttestChallenge$
  "https://firebase.google.com/docs/app-checkapi/reference/rest/v1beta/projects/apps/generateAppAttestChallenge
  
  Required parameters: app
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Initiates the App Attest flow by generating a challenge which will be used as a type of nonce for this attestation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:app})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1beta/{+app}:generateAppAttestChallenge"
     #{:app}
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

(defn apps-exchangeCustomToken$
  "https://firebase.google.com/docs/app-checkapi/reference/rest/v1beta/projects/apps/exchangeCustomToken
  
  Required parameters: app
  
  Optional parameters: none
  
  Body: 
  
  {:customToken string}
  
  Validates a custom token signed using your project's Admin SDK service account credentials. If valid, returns an App Check token encapsulated in an AttestationTokenResponse."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:app})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1beta/{+app}:exchangeCustomToken"
     #{:app}
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

(defn apps-exchangeDebugToken$
  "https://firebase.google.com/docs/app-checkapi/reference/rest/v1beta/projects/apps/exchangeDebugToken
  
  Required parameters: app
  
  Optional parameters: none
  
  Body: 
  
  {:debugToken string}
  
  Validates a debug token secret that you have previously created using CreateDebugToken. If valid, returns an App Check token encapsulated in an AttestationTokenResponse. Note that a restrictive quota is enforced on this method to prevent accidental exposure of the app to abuse."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:app})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1beta/{+app}:exchangeDebugToken"
     #{:app}
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

(defn apps-debugTokens-delete$
  "https://firebase.google.com/docs/app-checkapi/reference/rest/v1beta/projects/apps/debugTokens/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified DebugToken. A deleted debug token cannot be used to exchange for an App Check token. Use this method when you suspect the secret `token` has been compromised or when you no longer need the debug token."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
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

(defn apps-debugTokens-list$
  "https://firebase.google.com/docs/app-checkapi/reference/rest/v1beta/projects/apps/debugTokens/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists all DebugTokens for the specified app. For security reasons, the `token` field is never populated in the response."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1beta/{+parent}/debugTokens"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apps-debugTokens-patch$
  "https://firebase.google.com/docs/app-checkapi/reference/rest/v1beta/projects/apps/debugTokens/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:displayName string, :token string, :name string}
  
  Updates the specified DebugToken. For security reasons, the `token` field cannot be updated, nor will it be populated in the response, but you can revoke the debug token using DeleteDebugToken."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1beta/{+name}"
     #{:name}
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

(defn apps-debugTokens-get$
  "https://firebase.google.com/docs/app-checkapi/reference/rest/v1beta/projects/apps/debugTokens/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the specified DebugToken. For security reasons, the `token` field is never populated in the response."
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

(defn apps-debugTokens-create$
  "https://firebase.google.com/docs/app-checkapi/reference/rest/v1beta/projects/apps/debugTokens/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:displayName string, :token string, :name string}
  
  Creates a new DebugToken for the specified app. For security reasons, after the creation operation completes, the `token` field cannot be updated or retrieved, but you can revoke the debug token using DeleteDebugToken. Each app can have a maximum of 20 debug tokens."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1beta/{+parent}/debugTokens"
     #{:parent}
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

(defn apps-appAttestConfig-get$
  "https://firebase.google.com/docs/app-checkapi/reference/rest/v1beta/projects/apps/appAttestConfig/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the AppAttestConfig for the specified app."
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

(defn apps-appAttestConfig-patch$
  "https://firebase.google.com/docs/app-checkapi/reference/rest/v1beta/projects/apps/appAttestConfig/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string, :tokenTtl string}
  
  Updates the AppAttestConfig for the specified app. While this configuration is incomplete or invalid, the app will be unable to exchange AppAttest tokens for App Check tokens."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1beta/{+name}"
     #{:name}
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

(defn apps-appAttestConfig-batchGet$
  "https://firebase.google.com/docs/app-checkapi/reference/rest/v1beta/projects/apps/appAttestConfig/batchGet
  
  Required parameters: parent
  
  Optional parameters: names
  
  Gets the AppAttestConfigs for the specified list of apps atomically."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1beta/{+parent}/apps/-/appAttestConfig:batchGet"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apps-deviceCheckConfig-patch$
  "https://firebase.google.com/docs/app-checkapi/reference/rest/v1beta/projects/apps/deviceCheckConfig/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:privateKey string,
   :privateKeySet boolean,
   :name string,
   :tokenTtl string,
   :keyId string}
  
  Updates the DeviceCheckConfig for the specified app. While this configuration is incomplete or invalid, the app will be unable to exchange DeviceCheck tokens for App Check tokens. For security reasons, the `private_key` field is never populated in the response."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1beta/{+name}"
     #{:name}
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

(defn apps-deviceCheckConfig-get$
  "https://firebase.google.com/docs/app-checkapi/reference/rest/v1beta/projects/apps/deviceCheckConfig/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the DeviceCheckConfig for the specified app. For security reasons, the `private_key` field is never populated in the response."
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

(defn apps-deviceCheckConfig-batchGet$
  "https://firebase.google.com/docs/app-checkapi/reference/rest/v1beta/projects/apps/deviceCheckConfig/batchGet
  
  Required parameters: parent
  
  Optional parameters: names
  
  Gets the DeviceCheckConfigs for the specified list of apps atomically. For security reasons, the `private_key` field is never populated in the response."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1beta/{+parent}/apps/-/deviceCheckConfig:batchGet"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apps-safetyNetConfig-get$
  "https://firebase.google.com/docs/app-checkapi/reference/rest/v1beta/projects/apps/safetyNetConfig/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the SafetyNetConfig for the specified app."
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

(defn apps-safetyNetConfig-batchGet$
  "https://firebase.google.com/docs/app-checkapi/reference/rest/v1beta/projects/apps/safetyNetConfig/batchGet
  
  Required parameters: parent
  
  Optional parameters: names
  
  Gets the SafetyNetConfigs for the specified list of apps atomically."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1beta/{+parent}/apps/-/safetyNetConfig:batchGet"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apps-safetyNetConfig-patch$
  "https://firebase.google.com/docs/app-checkapi/reference/rest/v1beta/projects/apps/safetyNetConfig/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string, :tokenTtl string}
  
  Updates the SafetyNetConfig for the specified app. While this configuration is incomplete or invalid, the app will be unable to exchange SafetyNet tokens for App Check tokens."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1beta/{+name}"
     #{:name}
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

(defn apps-recaptchaConfig-get$
  "https://firebase.google.com/docs/app-checkapi/reference/rest/v1beta/projects/apps/recaptchaConfig/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the RecaptchaConfig for the specified app. For security reasons, the `site_secret` field is never populated in the response."
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

(defn apps-recaptchaConfig-batchGet$
  "https://firebase.google.com/docs/app-checkapi/reference/rest/v1beta/projects/apps/recaptchaConfig/batchGet
  
  Required parameters: parent
  
  Optional parameters: names
  
  Gets the RecaptchaConfigs for the specified list of apps atomically. For security reasons, the `site_secret` field is never populated in the response."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1beta/{+parent}/apps/-/recaptchaConfig:batchGet"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apps-recaptchaConfig-patch$
  "https://firebase.google.com/docs/app-checkapi/reference/rest/v1beta/projects/apps/recaptchaConfig/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :tokenTtl string,
   :siteSecretSet boolean,
   :siteSecret string}
  
  Updates the RecaptchaConfig for the specified app. While this configuration is incomplete or invalid, the app will be unable to exchange reCAPTCHA tokens for App Check tokens. For security reasons, the `site_secret` field is never populated in the response."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1beta/{+name}"
     #{:name}
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

(defn services-batchUpdate$
  "https://firebase.google.com/docs/app-checkapi/reference/rest/v1beta/projects/services/batchUpdate
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:updateMask string,
               :service GoogleFirebaseAppcheckV1betaService}],
   :updateMask string}
  
  Updates the specified Service configurations atomically."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1beta/{+parent}/services:batchUpdate"
     #{:parent}
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

(defn services-get$
  "https://firebase.google.com/docs/app-checkapi/reference/rest/v1beta/projects/services/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the Service configuration for the specified service name."
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

(defn services-patch$
  "https://firebase.google.com/docs/app-checkapi/reference/rest/v1beta/projects/services/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string, :enforcementMode string}
  
  Updates the specified Service configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1beta/{+name}"
     #{:name}
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

(defn services-list$
  "https://firebase.google.com/docs/app-checkapi/reference/rest/v1beta/projects/services/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists all Service configurations for the specified project. Only Services which were explicitly configured using UpdateService or BatchUpdateServices will be returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebaseappcheck.googleapis.com/"
     "v1beta/{+parent}/services"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
