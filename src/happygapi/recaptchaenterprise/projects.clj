(ns happygapi.recaptchaenterprise.projects
  "reCAPTCHA Enterprise API: projects.
  Help protect your website from fraudulent activity, spam, and abuse without creating friction.
  See: https://cloud.google.com/recaptcha-enterprise/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn firewallpolicies-patch$
  "https://cloud.google.com/recaptcha-enterprise/api/reference/rest/v1/projects/firewallpolicies/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:actions [{:block GoogleCloudRecaptchaenterpriseV1FirewallActionBlockAction,
              :setHeader GoogleCloudRecaptchaenterpriseV1FirewallActionSetHeaderAction,
              :allow GoogleCloudRecaptchaenterpriseV1FirewallActionAllowAction,
              :substitute GoogleCloudRecaptchaenterpriseV1FirewallActionSubstituteAction,
              :includeRecaptchaScript GoogleCloudRecaptchaenterpriseV1FirewallActionIncludeRecaptchaScriptAction,
              :redirect GoogleCloudRecaptchaenterpriseV1FirewallActionRedirectAction}],
   :condition string,
   :description string,
   :path string,
   :name string}
  
  Updates the specified firewall policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://recaptchaenterprise.googleapis.com/"
     "v1/{+name}"
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

(defn firewallpolicies-get$
  "https://cloud.google.com/recaptcha-enterprise/api/reference/rest/v1/projects/firewallpolicies/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the specified firewall policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://recaptchaenterprise.googleapis.com/"
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

(defn firewallpolicies-delete$
  "https://cloud.google.com/recaptcha-enterprise/api/reference/rest/v1/projects/firewallpolicies/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified firewall policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://recaptchaenterprise.googleapis.com/"
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

(defn firewallpolicies-list$
  "https://cloud.google.com/recaptcha-enterprise/api/reference/rest/v1/projects/firewallpolicies/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Returns the list of all firewall policies that belong to a project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://recaptchaenterprise.googleapis.com/"
     "v1/{+parent}/firewallpolicies"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn firewallpolicies-reorder$
  "https://cloud.google.com/recaptcha-enterprise/api/reference/rest/v1/projects/firewallpolicies/reorder
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:names [string]}
  
  Reorders all firewall policies."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://recaptchaenterprise.googleapis.com/"
     "v1/{+parent}/firewallpolicies:reorder"
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

(defn firewallpolicies-create$
  "https://cloud.google.com/recaptcha-enterprise/api/reference/rest/v1/projects/firewallpolicies/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:actions [{:block GoogleCloudRecaptchaenterpriseV1FirewallActionBlockAction,
              :setHeader GoogleCloudRecaptchaenterpriseV1FirewallActionSetHeaderAction,
              :allow GoogleCloudRecaptchaenterpriseV1FirewallActionAllowAction,
              :substitute GoogleCloudRecaptchaenterpriseV1FirewallActionSubstituteAction,
              :includeRecaptchaScript GoogleCloudRecaptchaenterpriseV1FirewallActionIncludeRecaptchaScriptAction,
              :redirect GoogleCloudRecaptchaenterpriseV1FirewallActionRedirectAction}],
   :condition string,
   :description string,
   :path string,
   :name string}
  
  Creates a new FirewallPolicy, specifying conditions at which reCAPTCHA Enterprise actions can be executed. A project may have a maximum of 1000 policies."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://recaptchaenterprise.googleapis.com/"
     "v1/{+parent}/firewallpolicies"
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

(defn relatedaccountgroups-list$
  "https://cloud.google.com/recaptcha-enterprise/api/reference/rest/v1/projects/relatedaccountgroups/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  List groups of related accounts."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://recaptchaenterprise.googleapis.com/"
     "v1/{+parent}/relatedaccountgroups"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn relatedaccountgroups-memberships-list$
  "https://cloud.google.com/recaptcha-enterprise/api/reference/rest/v1/projects/relatedaccountgroups/memberships/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Get memberships in a group of related accounts."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://recaptchaenterprise.googleapis.com/"
     "v1/{+parent}/memberships"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn assessments-annotate$
  "https://cloud.google.com/recaptcha-enterprise/api/reference/rest/v1/projects/assessments/annotate
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:transactionEvent {:eventType string,
                      :reason string,
                      :eventTime string,
                      :value number},
   :reasons [string],
   :hashedAccountId string,
   :annotation string,
   :accountId string}
  
  Annotates a previously created Assessment to provide additional information on whether the event turned out to be authentic or fraudulent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://recaptchaenterprise.googleapis.com/"
     "v1/{+name}:annotate"
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

(defn assessments-create$
  "https://cloud.google.com/recaptcha-enterprise/api/reference/rest/v1/projects/assessments/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:accountVerification {:endpoints [GoogleCloudRecaptchaenterpriseV1EndpointVerificationInfo],
                         :username string,
                         :latestVerificationResult string,
                         :languageCode string},
   :riskAnalysis {:extendedVerdictReasons [string],
                  :reasons [string],
                  :score number},
   :accountDefenderAssessment {:labels [string]},
   :name string,
   :fraudSignals {:userSignals GoogleCloudRecaptchaenterpriseV1FraudSignalsUserSignals,
                  :cardSignals GoogleCloudRecaptchaenterpriseV1FraudSignalsCardSignals},
   :event {:express boolean,
           :wafTokenAssessment boolean,
           :siteKey string,
           :firewallPolicyEvaluation boolean,
           :headers [string],
           :token string,
           :transactionData GoogleCloudRecaptchaenterpriseV1TransactionData,
           :userIpAddress string,
           :userAgent string,
           :ja3 string,
           :hashedAccountId string,
           :expectedAction string,
           :userInfo GoogleCloudRecaptchaenterpriseV1UserInfo,
           :requestedUri string},
   :fraudPreventionAssessment {:cardTestingVerdict GoogleCloudRecaptchaenterpriseV1FraudPreventionAssessmentCardTestingVerdict,
                               :transactionRisk number,
                               :behavioralTrustVerdict GoogleCloudRecaptchaenterpriseV1FraudPreventionAssessmentBehavioralTrustVerdict,
                               :stolenInstrumentVerdict GoogleCloudRecaptchaenterpriseV1FraudPreventionAssessmentStolenInstrumentVerdict},
   :firewallPolicyAssessment {:firewallPolicy GoogleCloudRecaptchaenterpriseV1FirewallPolicy,
                              :error GoogleRpcStatus},
   :privatePasswordLeakVerification {:encryptedUserCredentialsHash string,
                                     :lookupHashPrefix string,
                                     :encryptedLeakMatchPrefixes [string],
                                     :reencryptedUserCredentialsHash string},
   :tokenProperties {:createTime string,
                     :action string,
                     :iosBundleId string,
                     :valid boolean,
                     :invalidReason string,
                     :androidPackageName string,
                     :hostname string}}
  
  Creates an Assessment of the likelihood an event is legitimate."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://recaptchaenterprise.googleapis.com/"
     "v1/{+parent}/assessments"
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

(defn keys-create$
  "https://cloud.google.com/recaptcha-enterprise/api/reference/rest/v1/projects/keys/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:labels {},
   :wafSettings {:wafFeature string, :wafService string},
   :displayName string,
   :name string,
   :webSettings {:allowAllDomains boolean,
                 :integrationType string,
                 :challengeSecurityPreference string,
                 :allowAmpTraffic boolean,
                 :allowedDomains [string]},
   :createTime string,
   :androidSettings {:allowedPackageNames [string],
                     :allowAllPackageNames boolean,
                     :supportNonGoogleAppStoreDistribution boolean},
   :testingOptions {:testingChallenge string, :testingScore number},
   :iosSettings {:allowAllBundleIds boolean,
                 :appleDeveloperId GoogleCloudRecaptchaenterpriseV1AppleDeveloperId,
                 :allowedBundleIds [string]}}
  
  Creates a new reCAPTCHA Enterprise key."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://recaptchaenterprise.googleapis.com/"
     "v1/{+parent}/keys"
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

(defn keys-patch$
  "https://cloud.google.com/recaptcha-enterprise/api/reference/rest/v1/projects/keys/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:labels {},
   :wafSettings {:wafFeature string, :wafService string},
   :displayName string,
   :name string,
   :webSettings {:allowAllDomains boolean,
                 :integrationType string,
                 :challengeSecurityPreference string,
                 :allowAmpTraffic boolean,
                 :allowedDomains [string]},
   :createTime string,
   :androidSettings {:allowedPackageNames [string],
                     :allowAllPackageNames boolean,
                     :supportNonGoogleAppStoreDistribution boolean},
   :testingOptions {:testingChallenge string, :testingScore number},
   :iosSettings {:allowAllBundleIds boolean,
                 :appleDeveloperId GoogleCloudRecaptchaenterpriseV1AppleDeveloperId,
                 :allowedBundleIds [string]}}
  
  Updates the specified key."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://recaptchaenterprise.googleapis.com/"
     "v1/{+name}"
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

(defn keys-retrieveLegacySecretKey$
  "https://cloud.google.com/recaptcha-enterprise/api/reference/rest/v1/projects/keys/retrieveLegacySecretKey
  
  Required parameters: key
  
  Optional parameters: none
  
  Returns the secret key related to the specified public key. You must use the legacy secret key only in a 3rd party integration with legacy reCAPTCHA."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:key})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://recaptchaenterprise.googleapis.com/"
     "v1/{+key}:retrieveLegacySecretKey"
     #{:key}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn keys-get$
  "https://cloud.google.com/recaptcha-enterprise/api/reference/rest/v1/projects/keys/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the specified key."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://recaptchaenterprise.googleapis.com/"
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

(defn keys-delete$
  "https://cloud.google.com/recaptcha-enterprise/api/reference/rest/v1/projects/keys/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified key."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://recaptchaenterprise.googleapis.com/"
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

(defn keys-getMetrics$
  "https://cloud.google.com/recaptcha-enterprise/api/reference/rest/v1/projects/keys/getMetrics
  
  Required parameters: name
  
  Optional parameters: none
  
  Get some aggregated metrics for a Key. This data can be used to build dashboards."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://recaptchaenterprise.googleapis.com/"
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

(defn keys-migrate$
  "https://cloud.google.com/recaptcha-enterprise/api/reference/rest/v1/projects/keys/migrate
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:skipBillingCheck boolean}
  
  Migrates an existing key from reCAPTCHA to reCAPTCHA Enterprise. Once a key is migrated, it can be used from either product. SiteVerify requests are billed as CreateAssessment calls. You must be authenticated as one of the current owners of the reCAPTCHA Key, and your user must have the reCAPTCHA Enterprise Admin IAM role in the destination project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://recaptchaenterprise.googleapis.com/"
     "v1/{+name}:migrate"
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

(defn keys-list$
  "https://cloud.google.com/recaptcha-enterprise/api/reference/rest/v1/projects/keys/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Returns the list of all keys that belong to a project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://recaptchaenterprise.googleapis.com/"
     "v1/{+parent}/keys"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn relatedaccountgroupmemberships-search$
  "https://cloud.google.com/recaptcha-enterprise/api/reference/rest/v1/projects/relatedaccountgroupmemberships/search
  
  Required parameters: project
  
  Optional parameters: none
  
  Body: 
  
  {:hashedAccountId string,
   :pageSize integer,
   :accountId string,
   :pageToken string}
  
  Search group memberships related to a given account."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://recaptchaenterprise.googleapis.com/"
     "v1/{+project}/relatedaccountgroupmemberships:search"
     #{:project}
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
