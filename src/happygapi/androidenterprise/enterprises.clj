(ns happygapi.androidenterprise.enterprises
  "Google Play EMM API: enterprises.
  Manages the deployment of apps to Android Enterprise devices.
  See: https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/enterprises"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn setAccount$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/enterprises/setAccount
  
  Required parameters: enterpriseId
  
  Optional parameters: none
  
  Body: 
  
  {:accountEmail string}
  
  Sets the account that will be used to authenticate to the API as the enterprise."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:enterpriseId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/{enterpriseId}/account"
     #{:enterpriseId}
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

(defn getStoreLayout$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/enterprises/getStoreLayout
  
  Required parameters: enterpriseId
  
  Optional parameters: none
  
  Returns the store layout for the enterprise. If the store layout has not been set, returns \"basic\" as the store layout type and no homepage."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:enterpriseId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/{enterpriseId}/storeLayout"
     #{:enterpriseId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/enterprises/get
  
  Required parameters: enterpriseId
  
  Optional parameters: none
  
  Retrieves the name and domain of an enterprise."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:enterpriseId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/{enterpriseId}"
     #{:enterpriseId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn createWebToken$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/enterprises/createWebToken
  
  Required parameters: enterpriseId
  
  Optional parameters: none
  
  Body: 
  
  {:webApps {:enabled boolean},
   :playSearch {:approveApps boolean, :enabled boolean},
   :managedConfigurations {:enabled boolean},
   :permission [string],
   :privateApps {:enabled boolean},
   :zeroTouch {:enabled boolean},
   :storeBuilder {:enabled boolean},
   :parent string}
  
  Returns a unique token to access an embeddable UI. To generate a web UI, pass the generated token into the managed Google Play javascript API. Each token may only be used to start one UI session. See the javascript API documentation for further information."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:enterpriseId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/{enterpriseId}/createWebToken"
     #{:enterpriseId}
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

(defn generateSignupUrl$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/enterprises/generateSignupUrl
  
  Required parameters: none
  
  Optional parameters: callbackUrl
  
  Generates a sign-up URL."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/signupUrl"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn unenroll$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/enterprises/unenroll
  
  Required parameters: enterpriseId
  
  Optional parameters: none
  
  Unenrolls an enterprise from the calling EMM."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:enterpriseId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/{enterpriseId}/unenroll"
     #{:enterpriseId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn completeSignup$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/enterprises/completeSignup
  
  Required parameters: none
  
  Optional parameters: completionToken, enterpriseToken
  
  Completes the signup flow, by specifying the Completion token and Enterprise token. This request must not be called multiple times for a given Enterprise Token."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/completeSignup"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setStoreLayout$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/enterprises/setStoreLayout
  
  Required parameters: enterpriseId
  
  Optional parameters: none
  
  Body: 
  
  {:homepageId string, :storeLayoutType string}
  
  Sets the store layout for the enterprise. By default, storeLayoutType is set to \"basic\" and the basic store layout is enabled. The basic layout only contains apps approved by the admin, and that have been added to the available product set for a user (using the setAvailableProductSet call). Apps on the page are sorted in order of their product ID value. If you create a custom store layout (by setting storeLayoutType = \"custom\" and setting a homepage), the basic store layout is disabled."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:enterpriseId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/{enterpriseId}/storeLayout"
     #{:enterpriseId}
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

(defn acknowledgeNotificationSet$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/enterprises/acknowledgeNotificationSet
  
  Required parameters: none
  
  Optional parameters: notificationSetId
  
  Acknowledges notifications that were received from Enterprises.PullNotificationSet to prevent subsequent calls from returning the same notifications."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/acknowledgeNotificationSet"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn pullNotificationSet$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/enterprises/pullNotificationSet
  
  Required parameters: none
  
  Optional parameters: requestMode
  
  Pulls and returns a notification set for the enterprises associated with the service account authenticated for the request. The notification set may be empty if no notification are pending. A notification set returned needs to be acknowledged within 20 seconds by calling Enterprises.AcknowledgeNotificationSet, unless the notification set is empty. Notifications that are not acknowledged within the 20 seconds will eventually be included again in the response to another PullNotificationSet request, and those that are never acknowledged will ultimately be deleted according to the Google Cloud Platform Pub/Sub system policy. Multiple requests might be performed concurrently to retrieve notifications, in which case the pending notifications (if any) will be split among each caller, if any are pending. If no notifications are present, an empty notification list is returned. Subsequent requests may return more notifications once they become available."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/pullNotificationSet"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/enterprises/list
  
  Required parameters: domain
  
  Optional parameters: none
  
  Looks up an enterprise by domain name. This is only supported for enterprises created via the Google-initiated creation flow. Lookup of the id is not needed for enterprises created via the EMM-initiated flow since the EMM learns the enterprise ID in the callback specified in the Enterprises.generateSignupUrl call."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:domain})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises"
     #{:domain}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sendTestPushNotification$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/enterprises/sendTestPushNotification
  
  Required parameters: enterpriseId
  
  Optional parameters: none
  
  Sends a test notification to validate the EMM integration with the Google Cloud Pub/Sub service for this enterprise."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:enterpriseId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/{enterpriseId}/sendTestPushNotification"
     #{:enterpriseId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getServiceAccount$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/enterprises/getServiceAccount
  
  Required parameters: enterpriseId
  
  Optional parameters: keyType
  
  Returns a service account and credentials. The service account can be bound to the enterprise by calling setAccount. The service account is unique to this enterprise and EMM, and will be deleted if the enterprise is unbound. The credentials contain private key data and are not stored server-side. This method can only be called after calling Enterprises.Enroll or Enterprises.CompleteSignup, and before Enterprises.SetAccount; at other times it will return an error. Subsequent calls after the first will generate a new, unique set of credentials, and invalidate the previously generated credentials. Once the service account is bound to the enterprise, it can be managed using the serviceAccountKeys resource."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:enterpriseId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/{enterpriseId}/serviceAccount"
     #{:enterpriseId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn enroll$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/enterprises/enroll
  
  Required parameters: token
  
  Optional parameters: none
  
  Body: 
  
  {:primaryDomain string,
   :administrator [{:email string}],
   :id string,
   :name string}
  
  Enrolls an enterprise with the calling EMM."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:token})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/enroll"
     #{:token}
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
