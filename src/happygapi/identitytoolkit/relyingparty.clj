(ns happygapi.identitytoolkit.relyingparty
  "Google Identity Toolkit API: relyingparty.
  Help the third party sites to implement federated login.
  See: https://developers.google.com/identity-toolkit/v3/api/reference/rest/v3/relyingparty"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn verifyPhoneNumber$
  "https://developers.google.com/identity-toolkit/v3/api/reference/rest/v3/relyingparty/verifyPhoneNumber
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:verificationProof string,
   :temporaryProof string,
   :sessionInfo string,
   :phoneNumber string,
   :code string,
   :idToken string,
   :operation string}
  
  Verifies ownership of a phone number and creates/updates the user account accordingly."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/"
     "verifyPhoneNumber"
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

(defn deleteAccount$
  "https://developers.google.com/identity-toolkit/v3/api/reference/rest/v3/relyingparty/deleteAccount
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:idToken string, :localId string, :delegatedProjectNumber string}
  
  Delete user account."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/"
     "deleteAccount"
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

(defn signupNewUser$
  "https://developers.google.com/identity-toolkit/v3/api/reference/rest/v3/relyingparty/signupNewUser
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:tenantId string,
   :tenantProjectNumber string,
   :email string,
   :disabled boolean,
   :instanceId string,
   :password string,
   :displayName string,
   :idToken string,
   :captchaResponse string,
   :captchaChallenge string,
   :emailVerified boolean,
   :localId string,
   :photoUrl string,
   :phoneNumber string}
  
  Signup new user."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/"
     "signupNewUser"
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

(defn setProjectConfig$
  "https://developers.google.com/identity-toolkit/v3/api/reference/rest/v3/relyingparty/setProjectConfig
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:allowPasswordUser boolean,
   :authorizedDomains [string],
   :legacyResetPasswordTemplate {:from string,
                                 :replyTo string,
                                 :subject string,
                                 :format string,
                                 :fromDisplayName string,
                                 :body string},
   :changeEmailTemplate {:from string,
                         :replyTo string,
                         :subject string,
                         :format string,
                         :fromDisplayName string,
                         :body string},
   :idpConfig [{:clientId string,
                :secret string,
                :whitelistedAudiences [string],
                :experimentPercent integer,
                :enabled boolean,
                :provider string}],
   :apiKey string,
   :enableAnonymousUser boolean,
   :verifyEmailTemplate {:from string,
                         :replyTo string,
                         :subject string,
                         :format string,
                         :fromDisplayName string,
                         :body string},
   :useEmailSending boolean,
   :delegatedProjectNumber string,
   :resetPasswordTemplate {:from string,
                           :replyTo string,
                           :subject string,
                           :format string,
                           :fromDisplayName string,
                           :body string}}
  
  Set project configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/"
     "setProjectConfig"
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

(defn getProjectConfig$
  "https://developers.google.com/identity-toolkit/v3/api/reference/rest/v3/relyingparty/getProjectConfig
  
  Required parameters: none
  
  Optional parameters: projectNumber, delegatedProjectNumber
  
  Get project configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/"
     "getProjectConfig"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn verifyPassword$
  "https://developers.google.com/identity-toolkit/v3/api/reference/rest/v3/relyingparty/verifyPassword
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:tenantId string,
   :tenantProjectNumber string,
   :email string,
   :returnSecureToken boolean,
   :instanceId string,
   :password string,
   :idToken string,
   :captchaResponse string,
   :captchaChallenge string,
   :pendingIdToken string,
   :delegatedProjectNumber string}
  
  Verifies the user entered password."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/"
     "verifyPassword"
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

(defn sendVerificationCode$
  "https://developers.google.com/identity-toolkit/v3/api/reference/rest/v3/relyingparty/sendVerificationCode
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:iosSecret string,
   :phoneNumber string,
   :iosReceipt string,
   :recaptchaToken string}
  
  Send SMS verification code."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/"
     "sendVerificationCode"
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

(defn verifyCustomToken$
  "https://developers.google.com/identity-toolkit/v3/api/reference/rest/v3/relyingparty/verifyCustomToken
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:delegatedProjectNumber string,
   :instanceId string,
   :returnSecureToken boolean,
   :token string}
  
  Verifies the developer asserted ID token."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/"
     "verifyCustomToken"
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

(defn verifyAssertion$
  "https://developers.google.com/identity-toolkit/v3/api/reference/rest/v3/relyingparty/verifyAssertion
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:tenantId string,
   :tenantProjectNumber string,
   :autoCreate boolean,
   :returnSecureToken boolean,
   :sessionId string,
   :instanceId string,
   :idToken string,
   :requestUri string,
   :postBody string,
   :returnRefreshToken boolean,
   :pendingIdToken string,
   :returnIdpCredential boolean,
   :delegatedProjectNumber string}
  
  Verifies the assertion returned by the IdP."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/"
     "verifyAssertion"
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

(defn emailLinkSignin$
  "https://developers.google.com/identity-toolkit/v3/api/reference/rest/v3/relyingparty/emailLinkSignin
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:idToken string, :email string, :oobCode string}
  
  Reset password for a user."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/"
     "emailLinkSignin"
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

(defn getAccountInfo$
  "https://developers.google.com/identity-toolkit/v3/api/reference/rest/v3/relyingparty/getAccountInfo
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:idToken string,
   :phoneNumber [string],
   :localId [string],
   :email [string],
   :delegatedProjectNumber string}
  
  Returns the account info."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/"
     "getAccountInfo"
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

(defn resetPassword$
  "https://developers.google.com/identity-toolkit/v3/api/reference/rest/v3/relyingparty/resetPassword
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:oobCode string,
   :email string,
   :newPassword string,
   :oldPassword string}
  
  Reset password for a user."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/"
     "resetPassword"
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

(defn getOobConfirmationCode$
  "https://developers.google.com/identity-toolkit/v3/api/reference/rest/v3/relyingparty/getOobConfirmationCode
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:newEmail string,
   :continueUrl string,
   :userIp string,
   :email string,
   :iOSAppStoreId string,
   :captchaResp string,
   :idToken string,
   :androidInstallApp boolean,
   :challenge string,
   :kind string,
   :requestType string,
   :iOSBundleId string,
   :androidPackageName string,
   :canHandleCodeInApp boolean,
   :androidMinimumVersion string}
  
  Get a code for user action confirmation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/"
     "getOobConfirmationCode"
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

(defn signOutUser$
  "https://developers.google.com/identity-toolkit/v3/api/reference/rest/v3/relyingparty/signOutUser
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:localId string, :instanceId string}
  
  Sign out user."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/"
     "signOutUser"
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

(defn getPublicKeys$
  "https://developers.google.com/identity-toolkit/v3/api/reference/rest/v3/relyingparty/getPublicKeys
  
  Required parameters: none
  
  Optional parameters: none
  
  Get token signing public key."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/"
     "publicKeys"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setAccountInfo$
  "https://developers.google.com/identity-toolkit/v3/api/reference/rest/v3/relyingparty/setAccountInfo
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:email string,
   :deleteProvider [string],
   :returnSecureToken boolean,
   :validSince string,
   :instanceId string,
   :password string,
   :displayName string,
   :upgradeToFederatedLogin boolean,
   :customAttributes string,
   :createdAt string,
   :idToken string,
   :deleteAttribute [string],
   :captchaResponse string,
   :captchaChallenge string,
   :emailVerified boolean,
   :localId string,
   :photoUrl string,
   :oobCode string,
   :disableUser boolean,
   :phoneNumber string,
   :lastLoginAt string,
   :provider [string],
   :delegatedProjectNumber string}
  
  Set account info for a user."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/"
     "setAccountInfo"
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

(defn uploadAccount$
  "https://developers.google.com/identity-toolkit/v3/api/reference/rest/v3/relyingparty/uploadAccount
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:blockSize integer,
   :memoryCost integer,
   :targetProjectId string,
   :parallelization integer,
   :hashAlgorithm string,
   :cpuMemCost integer,
   :sanityCheck boolean,
   :dkLen integer,
   :allowOverwrite boolean,
   :rounds integer,
   :signerKey string,
   :saltSeparator string,
   :delegatedProjectNumber string,
   :users [{:salt string,
            :email string,
            :validSince string,
            :disabled boolean,
            :displayName string,
            :providerUserInfo [{:federatedId string,
                                :displayName string,
                                :email string,
                                :screenName string,
                                :phoneNumber string,
                                :providerId string,
                                :photoUrl string,
                                :rawId string}],
            :customAttributes string,
            :createdAt string,
            :emailVerified boolean,
            :customAuth boolean,
            :localId string,
            :passwordUpdatedAt number,
            :photoUrl string,
            :rawPassword string,
            :passwordHash string,
            :version integer,
            :screenName string,
            :phoneNumber string,
            :lastLoginAt string}]}
  
  Batch upload existing user accounts."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/"
     "uploadAccount"
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

(defn downloadAccount$
  "https://developers.google.com/identity-toolkit/v3/api/reference/rest/v3/relyingparty/downloadAccount
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:delegatedProjectNumber string,
   :nextPageToken string,
   :maxResults integer,
   :targetProjectId string}
  
  Batch download user accounts."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/"
     "downloadAccount"
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

(defn getRecaptchaParam$
  "https://developers.google.com/identity-toolkit/v3/api/reference/rest/v3/relyingparty/getRecaptchaParam
  
  Required parameters: none
  
  Optional parameters: none
  
  Get recaptcha secure param."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/"
     "getRecaptchaParam"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn createAuthUri$
  "https://developers.google.com/identity-toolkit/v3/api/reference/rest/v3/relyingparty/createAuthUri
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:tenantId string,
   :providerId string,
   :clientId string,
   :tenantProjectNumber string,
   :continueUri string,
   :sessionId string,
   :hostedDomain string,
   :otaApp string,
   :openidRealm string,
   :customParameter {},
   :authFlowType string,
   :oauthConsumerKey string,
   :oauthScope string,
   :appId string,
   :identifier string,
   :context string}
  
  Creates the URI used by the IdP to authenticate the user."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/identitytoolkit/v3/relyingparty/"
     "createAuthUri"
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
