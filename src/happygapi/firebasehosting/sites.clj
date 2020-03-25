(ns happygapi.firebasehosting.sites
  "Firebase Hosting API: sites.
  The Firebase Hosting REST API enables programmatic and customizable deployments to your Firebase-hosted sites. Use this REST API to deploy new or updated hosting configurations and content files.
  See: https://firebase.google.com/docs/hosting/api/reference/rest/v1beta1/sites"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn getConfig$
  "https://firebase.google.com/docs/hosting/api/reference/rest/v1beta1/sites/getConfig
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the Hosting metadata for a specific site."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/firebase"
            "https://www.googleapis.com/auth/firebase.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebasehosting.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn updateConfig$
  "https://firebase.google.com/docs/hosting/api/reference/rest/v1beta1/sites/updateConfig
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:maxVersions string}
  
  Sets the Hosting metadata for a specific site."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://firebasehosting.googleapis.com/"
     "v1beta1/{+name}"
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

(defn domains-list$
  "https://firebase.google.com/docs/hosting/api/reference/rest/v1beta1/sites/domains/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists the domains for the specified site."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/firebase"
            "https://www.googleapis.com/auth/firebase.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebasehosting.googleapis.com/"
     "v1beta1/{+parent}/domains"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn domains-get$
  "https://firebase.google.com/docs/hosting/api/reference/rest/v1beta1/sites/domains/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a domain mapping on the specified site."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/firebase"
            "https://www.googleapis.com/auth/firebase.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebasehosting.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn domains-update$
  "https://firebase.google.com/docs/hosting/api/reference/rest/v1beta1/sites/domains/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:status string,
   :site string,
   :domainName string,
   :updateTime string,
   :provisioning {:dnsFetchTime string,
                  :certChallengeDns CertDnsChallenge,
                  :certStatus string,
                  :certChallengeDiscoveredTxt [string],
                  :discoveredIps [string],
                  :expectedIps [string],
                  :dnsStatus string,
                  :certChallengeHttp CertHttpChallenge},
   :domainRedirect {:domainName string, :type string}}
  
  Updates the specified domain mapping, creating the mapping as if it does
  not exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://firebasehosting.googleapis.com/"
     "v1beta1/{+name}"
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

(defn domains-create$
  "https://firebase.google.com/docs/hosting/api/reference/rest/v1beta1/sites/domains/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:status string,
   :site string,
   :domainName string,
   :updateTime string,
   :provisioning {:dnsFetchTime string,
                  :certChallengeDns CertDnsChallenge,
                  :certStatus string,
                  :certChallengeDiscoveredTxt [string],
                  :discoveredIps [string],
                  :expectedIps [string],
                  :dnsStatus string,
                  :certChallengeHttp CertHttpChallenge},
   :domainRedirect {:domainName string, :type string}}
  
  Creates a domain mapping on the specified site."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebasehosting.googleapis.com/"
     "v1beta1/{+parent}/domains"
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

(defn domains-delete$
  "https://firebase.google.com/docs/hosting/api/reference/rest/v1beta1/sites/domains/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the existing domain mapping on the specified site."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://firebasehosting.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn channels-releases-list$
  "https://firebase.google.com/docs/hosting/api/reference/rest/v1beta1/sites/channels/releases/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists the releases that have been created on the specified site."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/firebase"
            "https://www.googleapis.com/auth/firebase.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebasehosting.googleapis.com/"
     "v1beta1/{+parent}/releases"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn channels-releases-create$
  "https://firebase.google.com/docs/hosting/api/reference/rest/v1beta1/sites/channels/releases/create
  
  Required parameters: parent
  
  Optional parameters: versionName
  
  Body: 
  
  {:message string,
   :releaseUser {:imageUrl string, :email string},
   :releaseTime string,
   :name string,
   :type string,
   :version {:labels {},
             :deleteTime string,
             :deleteUser ActingUser,
             :fileCount string,
             :config ServingConfig,
             :name string,
             :createTime string,
             :preview PreviewConfig,
             :status string,
             :createUser ActingUser,
             :versionBytes string,
             :finalizeTime string,
             :finalizeUser ActingUser}}
  
  Creates a new release which makes the content of the specified version
  actively display on the appropriate URL(s)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebasehosting.googleapis.com/"
     "v1beta1/{+parent}/releases"
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

(defn releases-list$
  "https://firebase.google.com/docs/hosting/api/reference/rest/v1beta1/sites/releases/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists the releases that have been created on the specified site."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/firebase"
            "https://www.googleapis.com/auth/firebase.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebasehosting.googleapis.com/"
     "v1beta1/{+parent}/releases"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn releases-create$
  "https://firebase.google.com/docs/hosting/api/reference/rest/v1beta1/sites/releases/create
  
  Required parameters: parent
  
  Optional parameters: versionName
  
  Body: 
  
  {:message string,
   :releaseUser {:imageUrl string, :email string},
   :releaseTime string,
   :name string,
   :type string,
   :version {:labels {},
             :deleteTime string,
             :deleteUser ActingUser,
             :fileCount string,
             :config ServingConfig,
             :name string,
             :createTime string,
             :preview PreviewConfig,
             :status string,
             :createUser ActingUser,
             :versionBytes string,
             :finalizeTime string,
             :finalizeUser ActingUser}}
  
  Creates a new release which makes the content of the specified version
  actively display on the appropriate URL(s)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebasehosting.googleapis.com/"
     "v1beta1/{+parent}/releases"
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

(defn versions-patch$
  "https://firebase.google.com/docs/hosting/api/reference/rest/v1beta1/sites/versions/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:labels {},
   :deleteTime string,
   :deleteUser {:imageUrl string, :email string},
   :fileCount string,
   :config {:appAssociation string,
            :trailingSlashBehavior string,
            :cleanUrls boolean,
            :rewrites [Rewrite],
            :redirects [Redirect],
            :headers [Header]},
   :name string,
   :createTime string,
   :preview {:expireTime string, :active boolean},
   :status string,
   :createUser {:imageUrl string, :email string},
   :versionBytes string,
   :finalizeTime string,
   :finalizeUser {:imageUrl string, :email string}}
  
  Updates the specified metadata for a version. Note that this method will
  fail with `FAILED_PRECONDITION` in the event of an invalid state
  transition. The only valid transition for a version is currently from a
  `CREATED` status to a `FINALIZED` status.
  Use [`DeleteVersion`](../sites.versions/delete) to set the status of a
  version to `DELETED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://firebasehosting.googleapis.com/"
     "v1beta1/{+name}"
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

(defn versions-populateFiles$
  "https://firebase.google.com/docs/hosting/api/reference/rest/v1beta1/sites/versions/populateFiles
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:files {}}
  
  Adds content files to a version."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebasehosting.googleapis.com/"
     "v1beta1/{+parent}:populateFiles"
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

(defn versions-delete$
  "https://firebase.google.com/docs/hosting/api/reference/rest/v1beta1/sites/versions/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified version."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://firebasehosting.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn versions-list$
  "https://firebase.google.com/docs/hosting/api/reference/rest/v1beta1/sites/versions/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists the versions that have been created on the specified site.
  Will include filtering in the future."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebasehosting.googleapis.com/"
     "v1beta1/{+parent}/versions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn versions-create$
  "https://firebase.google.com/docs/hosting/api/reference/rest/v1beta1/sites/versions/create
  
  Required parameters: parent
  
  Optional parameters: sizeBytes, versionId
  
  Body: 
  
  {:labels {},
   :deleteTime string,
   :deleteUser {:imageUrl string, :email string},
   :fileCount string,
   :config {:appAssociation string,
            :trailingSlashBehavior string,
            :cleanUrls boolean,
            :rewrites [Rewrite],
            :redirects [Redirect],
            :headers [Header]},
   :name string,
   :createTime string,
   :preview {:expireTime string, :active boolean},
   :status string,
   :createUser {:imageUrl string, :email string},
   :versionBytes string,
   :finalizeTime string,
   :finalizeUser {:imageUrl string, :email string}}
  
  Creates a new version for a site."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/firebase"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebasehosting.googleapis.com/"
     "v1beta1/{+parent}/versions"
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

(defn versions-clone$
  "https://firebase.google.com/docs/hosting/api/reference/rest/v1beta1/sites/versions/clone
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:exclude {:regexes [string]},
   :sourceVersion string,
   :finalize boolean,
   :include {:regexes [string]}}
  
  Creates a new version on the target site using the content
  of the specified version."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebasehosting.googleapis.com/"
     "v1beta1/{+parent}/versions:clone"
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

(defn versions-files-list$
  "https://firebase.google.com/docs/hosting/api/reference/rest/v1beta1/sites/versions/files/list
  
  Required parameters: parent
  
  Optional parameters: status, pageToken, pageSize
  
  Lists the remaining files to be uploaded for the specified version."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/firebase"
            "https://www.googleapis.com/auth/firebase.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firebasehosting.googleapis.com/"
     "v1beta1/{+parent}/files"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
