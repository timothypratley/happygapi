(ns happygapi.recaptchaenterprise.projects
  "reCAPTCHA Enterprise API: projects.
  
  See: https://cloud.google.com/recaptcha-enterprise/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn keys-create$
  "https://cloud.google.com/recaptcha-enterprise/api/reference/rest/v1/projects/keys/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:displayName string,
   :iosSettings {:allowAllBundleIds boolean, :allowedBundleIds [string]},
   :labels {},
   :androidSettings {:allowedPackageNames [string],
                     :allowAllPackageNames boolean},
   :webSettings {:allowAllDomains boolean,
                 :allowedDomains [string],
                 :integrationType string,
                 :challengeSecurityPreference string,
                 :allowAmpTraffic boolean},
   :testingOptions {:testingScore number, :testingChallenge string},
   :createTime string,
   :name string}
  
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

(defn keys-migrate$
  "https://cloud.google.com/recaptcha-enterprise/api/reference/rest/v1/projects/keys/migrate
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Migrates an existing key from reCAPTCHA to reCAPTCHA Enterprise. Once a key is migrated, it can be used from either product. SiteVerify requests are billed as CreateAssessment calls. You must be authenticated as one of the current owners of the reCAPTCHA Site Key, and your user must have the reCAPTCHA Enterprise Admin IAM role in the destination project."
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

(defn keys-patch$
  "https://cloud.google.com/recaptcha-enterprise/api/reference/rest/v1/projects/keys/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:displayName string,
   :iosSettings {:allowAllBundleIds boolean, :allowedBundleIds [string]},
   :labels {},
   :androidSettings {:allowedPackageNames [string],
                     :allowAllPackageNames boolean},
   :webSettings {:allowAllDomains boolean,
                 :allowedDomains [string],
                 :integrationType string,
                 :challengeSecurityPreference string,
                 :allowAmpTraffic boolean},
   :testingOptions {:testingScore number, :testingChallenge string},
   :createTime string,
   :name string}
  
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

(defn assessments-annotate$
  "https://cloud.google.com/recaptcha-enterprise/api/reference/rest/v1/projects/assessments/annotate
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:annotation string, :reasons [string]}
  
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
  
  {:riskAnalysis {:reasons [string], :score number},
   :tokenProperties {:createTime string,
                     :hostname string,
                     :invalidReason string,
                     :action string,
                     :valid boolean},
   :name string,
   :event {:token string,
           :userIpAddress string,
           :expectedAction string,
           :siteKey string,
           :userAgent string}}
  
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
